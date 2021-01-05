package com.testfan.MavenStudy.apistudy.HttpClient;

import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class CrmTestFZ {
    String ip;
    Map<Object,Object> param;
    Map<Object,Object> header;
    String token;
    @BeforeClass
    public void init(){
        ip = "http://192.168.23.129:8090";
        param = new HashMap<>();
        header = new HashMap<>();
    }

    @Test
    public void test001_login() throws IOException {
        param.put("username", "admin");
        param.put("password", "123456");
        String response = MyHttpMethod.PostForm(ip + "/login", param, header);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        token = JsonPath.from(response).getString("Admin-Token");
    }
    @Test
    public void test002_addCustomer(){

    }
}
