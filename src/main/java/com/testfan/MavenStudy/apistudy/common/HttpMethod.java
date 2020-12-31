package com.testfan.MavenStudy.apistudy.common;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

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
    public static String PostForm(String url,Map<Object,Object> params,Map<Object,Object> headers) throws IOException {
        httpPost = new HttpPost(url);
        //入参
        List<NameValuePair> paramlist= new ArrayList<>();
        Set<Map.Entry<Object, Object>> entrySet = params.entrySet();
        for (Map.Entry<Object, Object> entry:entrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
            NameValuePair param = new BasicNameValuePair(entry.getKey().toString(),entry.getValue().toString());
            paramlist.add(param);
        }
        //将paramsList对象转换成entity对象
        HttpEntity entity = new UrlEncodedFormEntity(paramlist);
        httpPost.setEntity(entity);
        // header
        Set<Map.Entry<Object, Object>> headersentry = headers.entrySet();
        for (Map.Entry<Object, Object> header:headersentry) {
            httpPost.setHeader(header.getKey().toString(),header.getValue().toString());
        }
        // 执行请求
        response = httpClient.execute(httpPost);
        //解析响应对象中的响应内容
        HttpEntity responseEntity = response.getEntity();//响应body体信息
        String resString = EntityUtils.toString(responseEntity,"utf-8");//将entity对象转换成字符串
        return resString;
    }

    //封装post：入参为json或者xml类型的方法
    public static String PostJsonOrXml(String url,String params,Map<Object,Object> headers) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        // 将json/xml的字符串转化为一个entity 对象
        HttpEntity entity = new StringEntity(params,"utf-8");
        httpPost.setEntity(entity);

        //header
        Set<Map.Entry<Object, Object>> headersentrySet = headers.entrySet();
        for (Map.Entry<Object, Object> entry:headersentrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
            httpPost.setHeader(entry.getKey().toString(),entry.getValue().toString());
        }

        //执行请求
        response = httpClient.execute(httpPost);
        //解析响应对象中的响应内容
        HttpEntity responseEntity = response.getEntity();//响应body
        String resString = EntityUtils.toString(responseEntity);//将entity对象转换成字符串

        return resString;
    }

    //封装上传文件的接口的封装
    public static void upload(){

    }

    /**
     * 获取响应信息中的响应状态码
     * @return
     */
    public static int getStatusCode(){
        int statusCode = response.getStatusLine().getStatusCode();
        return statusCode;
    }

    /**
     * 获取响应信息中的所有header
     * @return
     */
    public static Header[] getAllHeaders(){
        Header[] allHeaders = response.getAllHeaders();
        return allHeaders;
    }

    /**
     * 响应信息中的某一个header
     * @param headername
     * @return
     */
    public  static  Header[] getHeader(String headername){
        Header[] header = response.getHeaders(headername);
        return header;
    }














    public static void main(String[] args) throws Exception {
        Map<Object,Object> param =new HashMap<>();
        param.put("id","1");
        Map<Object,Object> header =new HashMap<>();

        String response = Get("http://192.168.23.129:8080/pinter/com/getSku", param, header);
        System.out.println(response);
    }

}
