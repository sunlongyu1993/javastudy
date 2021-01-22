package com.testfan.MavenStudy.apistudy.server;

import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210121
 *
 */
public class CrmDeleteCustomerServer {
    public static String url = "/CrmCustomer/deleteByIds";//接口地址
    public static String parampath = "src/main/resources/crmparams/deleteCustomer.properties";//参数配置文件路径
    /**
     * crm系统的登录接口，并且修改从文件中读取的参数
     * @param host
     * @param param:是个数组，可传可不传,表示需要修改参数配置文件中的某一个或多个参数的使用
     * @return
     * @throws Exception
     */
    public static String DeleteCustomer(String host,String token,Map<Object,Object>... param) throws Exception {
        //从文件中读取的参数
        Map<Object,Object> params = MyPropertisUtil.getAll(parampath);
        //遍历传入的你要修改的param:是以数组的形势传入
        for (int i = 0; i <param.length ; i++) {
            Map<Object, Object> map = param[i];
            Set<Map.Entry<Object, Object>> entrySet = map.entrySet();
            for (Map.Entry<Object, Object> entry :entrySet) {
                params.put(entry.getKey(),entry.getValue());//修改从文件中读取的参数
            }
        }
        Map<Object,Object> headers = new HashMap<>();
        headers.put("Admin-Token",token);//在头信息中添加token
        String response = MyHttpMethod.PostForm(host+url, params, headers);
        return response;
    }
    /**
     * crm登录接口，删除配置文件中的某个字段
     * @param host
     * @param keys:表示你要删除配置文件中的某一个字段或者多个字段
     * @return
     * @throws Exception
     */
    public static String DeleteCustomer(String host,String token,String[] keys) throws Exception {
        //从文件中读取的参数
        Map<Object,Object> params = MyPropertisUtil.getAll(parampath);
        //遍历传入的你要修改的param:是以数组的形势传入
        for (int i = 0; i <keys.length ; i++) {
           params.remove(keys[i]);
        }
        Map<Object,Object> headers = new HashMap<>();
        headers.put("Admin-Token",token);//在头信息中添加token
        String response = MyHttpMethod.PostForm(host+url, params, headers);
        return response;
    }

}
