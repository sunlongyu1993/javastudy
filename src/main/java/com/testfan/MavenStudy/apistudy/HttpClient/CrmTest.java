package com.testfan.MavenStudy.apistudy.HttpClient;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20201228
 */
public class CrmTest {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    String token;

    @Test
    public void test001_login() throws Exception {
        HttpPost httpPost = new HttpPost("http://192.168.23.129:8090/login");
        NameValuePair username = new BasicNameValuePair("username", "admin");
        NameValuePair pwd = new BasicNameValuePair("password", "123456");
        List<NameValuePair> params = new ArrayList<>();
        params.add(username);
        params.add(pwd);
        HttpEntity entity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(entity);

        CloseableHttpResponse response= httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity resentity = response.getEntity();
        String res = EntityUtils.toString(resentity);
        System.out.println(res);
        // 用fastjson 去解析会比较方便
        token = JsonPath.from(res).getString("Admin-Token");

    }
    @Test(dependsOnMethods = "test001_login")
    public void test002_addCustomer() throws Exception {
        HttpPost httpPost = new HttpPost("http://192.168.23.129:8090/CrmCustomer/addOrUpdate");
        httpPost.setHeader("Contenty_Type","application/json");
        httpPost.setHeader("Admin-Token",token);
        String params = "{  \"entity\": {\n" +
                "        \"customer_name\": \"客户\",\n" +
                "        \"mobile\": \"18810677201\",\n" +
                "        \"telephone\": \"18810677201\",\n" +
                "        \"website\": \"http://testfan.cn\",\n" +
                "        \"next_time\": \"2020-12-31 00:00:00\",\n" +
                "        \"remark\": \"备注\",\n" +
                "        \"address\": \"北京市,北京市,朝阳区\",\n" +
                "        \"detailAddress\": \"地铁14号线东段将台\",\n" +
                "        \"location\": \"地铁14号线东段将台\",\n" +
                "        \"lng\": 116.49652995682115,\n" +
                "        \"lat\": 39.976969081085144\n" +
                "    }}";
        HttpEntity entity = new StringEntity(params);
        httpPost.setEntity(entity);

        CloseableHttpResponse response= httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity resentity = response.getEntity();
        String res = EntityUtils.toString(resentity);
//        System.out.println(res);
    }
}
