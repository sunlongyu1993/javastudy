package com.testfan.MavenStudy.apistudy.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20201225
 */
public class MtxShopTest {
    CloseableHttpClient httpClient = HttpClients.createDefault();

    @Test// 登录成功
    public void test_001login() throws IOException {
        HttpPost httpPost = new HttpPost("http://192.168.23.129/mtx/public/index.php?s=/index/user/login.html");

        NameValuePair username = new BasicNameValuePair("accounts","slytest");
        NameValuePair pwd = new BasicNameValuePair("pwd","123456");
        List<NameValuePair> params = new ArrayList<>();
        params.add(username);
        params.add(pwd);

        HttpEntity entity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(entity);
        httpPost.setHeader("X-Requested-With","XMLHttpRequest");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity resentity = response.getEntity();
        String res = EntityUtils.toString(resentity);
        System.out.println(res);
        Assert.assertTrue(res.contains("登录成功"));
    }
    //@Test// 上传头像需要特殊处理
    public void test_002upload(){
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.23.129/mtx/index.php?s=/index/user/useravatarupload.html");
        httpPost.setHeader("X-Requested-With","XMLHttpRequest");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addTextBody("img_x","")
                .addTextBody("img_y","")
                .addTextBody("img_x","")
                .addTextBody("img_x","")
                .addTextBody("img_x","")
                .addBinaryBody("file",new File("C:\\Users\\sunlongyu\\Pictures\\Camera Roll\\2.jpg"), ContentType.IMAGE_JPEG,"2.jpg")
                .build();
    }
    @Test(dependsOnMethods = "test_001login")
    public void test003_shop() throws Exception {
        HttpPost httpPost = new HttpPost("http://192.168.23.129/mtx/index.php?s=/index/cart/save.html");
        httpPost.setHeader("X-Requested-With","XMLHttpRequest");
        NameValuePair goods = new BasicNameValuePair("goods_id","8");
        NameValuePair stock = new BasicNameValuePair("stock","1");
        List<NameValuePair> params = new ArrayList<>();
        params.add(goods);
        params.add(stock);

        HttpEntity entity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity resentity = response.getEntity();
        String res = EntityUtils.toString(resentity);
        System.out.println(res);
        Assert.assertTrue(res.contains("加入成功"));
    }
    @Test(dependsOnMethods = "test_001login")
    public void test004_order() throws Exception {
        HttpPost httpPost = new HttpPost("http://192.168.23.129/mtx/index.php?s=/index/buy/add.html");
        httpPost.setHeader("X-Requested-With","XMLHttpRequest");
        NameValuePair goods = new BasicNameValuePair("goods_id","5");
        NameValuePair buy_type = new BasicNameValuePair("buy_type","goods");
        NameValuePair stock = new BasicNameValuePair("stock","1");
        NameValuePair spec = new BasicNameValuePair("spec","[]");
        NameValuePair ids = new BasicNameValuePair("ids","");
        NameValuePair address_id = new BasicNameValuePair("address_id","7");
        NameValuePair payment_id = new BasicNameValuePair("payment_id","3");
        NameValuePair user_note = new BasicNameValuePair("user_note","");
        NameValuePair site_model = new BasicNameValuePair("site_model","0");
        List<NameValuePair> params = new ArrayList<>();
        params.add(goods);
        params.add(stock);
        params.add(buy_type);
        params.add(spec);
        params.add(ids);
        params.add(address_id);
        params.add(payment_id);
        params.add(user_note);
        params.add(site_model);

        HttpEntity entity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,200);

        HttpEntity resentity = response.getEntity();
        String res = EntityUtils.toString(resentity);
        System.out.println(res);
        Assert.assertTrue(res.contains("提交成功"));
    }
}
