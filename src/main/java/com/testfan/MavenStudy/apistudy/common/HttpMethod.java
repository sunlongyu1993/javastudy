package com.testfan.MavenStudy.apistudy.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20201229
 */
public class HttpMethod {
    public static  CloseableHttpClient httpClient;// 创建一个http客户端对象，用来执行http 接口对象
    public static  HttpPost httpPost;//post 请求对象
    public static  HttpGet httpGet;//get 请求对象
    public static  CloseableHttpResponse response; // 响应结果对象

    //采用静态代码块给静态类中的httpclient对象赋值，随之类的加载就给会httpclient对象赋值
    static {
        httpClient = HttpClients.createDefault();
    }

    // 封装get方法
    // 需要传入接口地址url,请求参数,以及headers信息
    public static String Get(String url, Map<Object,Object> params,Map<Object,Object> headers) throws Exception {
        //1、给http 对象赋值，对应get请求，参数是？a=**&b=*** 拼接到url 之后
        // 2、解析传入的参数，将其转化为 aaa = bbb；
        StringBuffer param = new StringBuffer();
        Set<Map.Entry<Object, Object>> entries = params.entrySet();
        for ( Map.Entry<Object, Object> entry :entries) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
            param.append("&"+entry.getKey()+"="+entry.getValue());
        }
//        System.out.println(param);
        // 替换第一个& 为？
        String paramstr = param.toString().replaceFirst("&", "?");
//        System.out.println(paramstr);
//      将拼接好带参数的url 给http 对象赋值
        HttpGet httpGet = new HttpGet(url+paramstr);
//         3、循环遍历传入的header对象，将其添加到httpGet对象中
        Set<Map.Entry<Object, Object>> entryHeader = params.entrySet();
        for ( Map.Entry<Object, Object> entry :entryHeader) {
            httpGet.setHeader(entry.getKey().toString(),entry.getValue().toString());
        }
        // 发起请求
        response = httpClient.execute(httpGet);
        //响应body 信息
        HttpEntity responseEntity = response.getEntity();
        // 将responseEntity 对象转化为字符串
        String response = EntityUtils.toString(responseEntity,"utf-8");
        return response;
    }
    // 封装post：入参为表单类型的方法
    //
    public void PostForm(String url) throws IOException {
        httpPost = new HttpPost(url);

        response = httpClient.execute(httpPost);

    }
//    //封装post：入参为json或者xml类型的方法
//    public void PostJsonOrXml(String url) throws IOException {
//        httpClient = HttpClients.createDefault();
//
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//    }
    public static void main(String[] args) throws Exception {
        Map<Object,Object> param =new HashMap<>();
        param.put("id","1");
        Map<Object,Object> header =new HashMap<>();

        String response = Get("http://192.168.23.129:8080/pinter/com/getSku", param, header);
        System.out.println(response);
    }

}
