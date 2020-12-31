package com.testfan.MavenStudy.apistudy.HttpClient;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20201225
 */
public class HttpPostStudy {
    @Test // 表单类型的post 接口
    public void Post() throws IOException {
        // 创建一个客户端对象，相当于你的浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建一个post 对象
        HttpPost httpPost = new HttpPost("http://192.168.23.129:8080/pinter/com/login");

        //1、设置请求参数-表单类型参数
        NameValuePair username = new BasicNameValuePair("userName","admin");
        NameValuePair pwd  = new BasicNameValuePair("password","123456");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(username);
        params.add(pwd);
        // 将params 对象设置为post对象的参数
        HttpEntity entity = new UrlEncodedFormEntity(params);//将参数转化为表单类型的entity对象
        httpPost.setEntity(entity);

        //执行httpclient httpPost 请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 获取返回值中的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
        // 获取响应body体信息
        HttpEntity resentity = response.getEntity();
        // 将body体信息转化为string
        String res = EntityUtils.toString(resentity,"utf-8");
        // 断言
        Assert.assertTrue(res.contains("success"));
        System.out.println(res);
    }

    @Test// 入参是json类型的的post 接口
    public void Post_Json() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.23.129:8080/pinter/com/register");
        String jsonString = "{\"userName\":\"test\",\"password\":\"1234\",\"gender\":1,\"phoneNum\":\"110\",\"email\":\"beihe@163.com\",\"address\":\"Beijing\"}";
        // 2.1设置参数
        // 将json字符串转化为一个entity 对象
        HttpEntity entity = new StringEntity(jsonString,"utf-8");
        httpPost.setEntity(entity);//设置参数
        //请求参数是json ,需要在头信息中添加此标示
        httpPost.setHeader("Content-Type","application/json");

        //使用httpclient httpPost 请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
        // 获取响应body体信息
        HttpEntity resentity = response.getEntity();
        // 将body体信息转化为string
        String res= EntityUtils.toString(resentity);
        System.out.println(res);

        // 断言
        Assert.assertTrue(res.contains("注册成功"));
    }

    @Test// xml的post 接口
    public void Post_Xml() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getDatabaseInfo xmlns=\"http://WebXml.com.cn/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        // 2.1设置参数
        // 将json字符串转化为一个entity 对象
        HttpEntity entity = new StringEntity(xmlString,"utf-8");
        httpPost.setEntity(entity);//设置参数
        //请求参数是xml ,需要在头信息中添加此标示
        httpPost.setHeader("Content-Type","text/xml");

        //使用httpclient httpPost 请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
        // 获取响应body体信息
        HttpEntity resentity = response.getEntity();
        // 将body体信息转化为string
        String res= EntityUtils.toString(resentity);
        System.out.println(res);

    }

}
