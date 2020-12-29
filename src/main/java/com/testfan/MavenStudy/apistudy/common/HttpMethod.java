package com.testfan.MavenStudy.apistudy.common;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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
    static {
        httpClient = HttpClients.createDefault();
    }

    // 封装get方法
    // 需要传入接口地址url,请求参数,以及headers信息
    public static void Get(String url, Map<Object,Object> params,Map<Object,Object> headers) throws Exception {
        //1、给http 对象赋值
        HttpGet httpGet = new HttpGet(url);
        // 2、解析传入的参数，将其转化为 aaa = bbb；
        Set<Map.Entry<Object, Object>> entries = params.entrySet();
        for ( Map.Entry<Object, Object> entry :entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        // 3、解析传入的header,将其添加到header中
        Set<Map.Entry<Object, Object>> entryHeader = params.entrySet();
        for ( Map.Entry<Object, Object> entry :entryHeader) {
            httpGet.setHeader(entry.getKey().toString(),entry.getValue().toString());
        }

//        response = httpClient.execute(httpGet);

    }
//    // 封装post：入参为表单类型的方法
//    public void PostForm(String url) throws IOException {
//        httpClient = HttpClients.createDefault();
//
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//
//    }
//    //封装post：入参为json或者xml类型的方法
//    public void PostJsonOrXml(String url) throws IOException {
//        httpClient = HttpClients.createDefault();
//
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//    }
    public static void main(String[] args) throws Exception {
        Map<Object,Object> param =new HashMap<>();
        param.put("aaa","111");
        param.put("bbb","111");
        Map<Object,Object> header =new HashMap<>();

        Get("http://192.168.23.129:8080/pinter/com/getSku",param,header);
    }

}
