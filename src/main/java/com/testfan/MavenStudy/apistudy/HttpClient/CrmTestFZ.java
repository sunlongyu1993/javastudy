package com.testfan.MavenStudy.apistudy.HttpClient;

import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.utils.MyPropertisUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class CrmTestFZ {
    String ip;
    Map<Object,Object> header;
    String token;
    @BeforeClass
    public void init(){
        ip = "http://192.168.23.129:8090";
        header = new HashMap<>();
    }

    @Test
    public void test001_login() throws Exception {
//        Map<Object,Object> param =  param = new HashMap<>();
//        param.put("username", "admin");
//        param.put("password", "123456");
        Map<Object, Object> param = MyPropertisUtil.getAll("src/main/resources/crmparams/crmlogin.properties");
        String response = MyHttpMethod.PostForm(ip + "/login", param, header);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String code = JsonPath.from(response).getString("code");
        Assert.assertEquals(code,"0");

        token = JsonPath.from(response).getString("Admin-Token");
        header.put("Admin-Token",token);
    }

    /***
     * 读取参数，参数json类型
     * @throws IOException
     */
    @Test(dependsOnMethods = "test001_login")
    public void test002_addCustomer() throws IOException {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();
        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");

    }
}
