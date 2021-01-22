package com.testfan.MavenStudy.apistudy.server;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONReader;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210121
 *
 */
public class CrmAddContactsServer {
//    public static String host = "http://192.168.23.135:8090";//需要传入的host
    public static String url = "/CrmContacts/addOrUpdate";//接口地址
    public static String parampath = "src/main/resources/crmparams/addContacts.json";//参数配置文件路径
    /**
     * 新增联系人业务层——修改参数中的值
     * @param host
     * @param token
     * @param maps:可填可不填，map中key 是需要修改的参数key,map的value是修改的值
     * @return
     * @throws Exception
     */
    public static String AddContacts(String host,String token,Map<Object,Object>...maps) throws Exception {
        Map<Object,Object> headers = new HashMap<>();//header
        headers.put("Admin-Token",token);//在头信息中添加token
//        从json 文件中读取json数据，并转为jsonpath类型数据
        JSONReader jsonReader = new JSONReader(new FileReader(parampath));
        JSONObject params = jsonReader.readObject(JSONObject.class);
        //修改参数中的值
        //遍历传入的你要修改的param:是以数组的形势传入
        for (int i = 0; i <maps.length ; i++) {
            Map<Object, Object> map = maps[i];
            Set<Map.Entry<Object, Object>> entrySet = map.entrySet();
            for (Map.Entry<Object, Object> entry :entrySet) {
                JSONPath.set(params,entry.getKey().toString(),entry.getValue());
            }
        }
        String response = MyHttpMethod.PostJson(host+url, params, headers);
        return response;
    }
    /**
     * 添加客户业务层——删除参数中的字端
     * @param host
     * @param token
     * @param jsonpaths：表示你要删除配置文件中的某一个字段或者多个字段
     * @return
     * @throws Exception
     */
    public static String AddContacts(String host,String token,String[] jsonpaths) throws Exception {
        Map<Object,Object> headers = new HashMap<>();//header
        headers.put("Admin-Token",token);//在头信息中添加token
//        从json 文件中读取json数据，并转为jsonpath类型数据
        JSONReader jsonReader = new JSONReader(new FileReader(parampath));
        JSONObject params = jsonReader.readObject(JSONObject.class);
        //修改参数中的值
        //遍历传入的你要修改的param:是以数组的形势传入
        for (int i = 0; i <jsonpaths.length ; i++) {
            JSONPath.remove(params,jsonpaths[i]);
        }
        String response = MyHttpMethod.PostJson(host+url, params, headers);
        return response;
    }

}
