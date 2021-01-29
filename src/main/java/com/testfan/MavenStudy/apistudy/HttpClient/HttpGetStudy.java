package com.testfan.MavenStudy.apistudy.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20201225
 */
public class HttpGetStudy {
    @Test
    public void Get() throws Exception {
        // 创建一个客户端对象，相当于你的浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建一个get 对象
        HttpGet httpGet = new HttpGet("http://192.168.23.135/mtx/");
        //使用httpclient 对象执行httpget 请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 获取返回值中的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);
        // 获取响应body体信息
        HttpEntity entity = response.getEntity();
        // 将body体信息转化为string
        String res = EntityUtils.toString(entity,"utf-8");
        // 断言
        Assert.assertTrue(res.contains("码同学"));

        System.out.println(res);
    }
    @Test
    public void Get_getSku() throws IOException {
        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://192.168.23.135:8080/pinter/com/getSku?id=1");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity,"utf-8");
        Assert.assertTrue(res.contains("success"));

    }




}
