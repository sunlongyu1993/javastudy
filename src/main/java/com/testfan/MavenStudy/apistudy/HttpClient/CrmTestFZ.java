package com.testfan.MavenStudy.apistudy.HttpClient;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
//        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");

    }
    @Test(dependsOnMethods = "test001_login",description = "客户名称为空")
    public void test003_addCustomer() throws IOException {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();

        //将参数进行转化
        JSONObject jsonObject = JSONObject.parseObject(param);
        //修改入参中的customer_name 为空
        JSONPath.set(jsonObject,"$.entity.customer_name","");
        //将替换后的jsonObject 重新赋值给param
        param = jsonObject.toString();

        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");
    }
    @Test(dependsOnMethods = "test001_login",description = "mobile为空")
    public void test004_addCustomer() throws IOException {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();
        JSONObject jsonObject = JSONObject.parseObject(param);
        JSONPath.set(jsonObject,"$.entity.mobile","");
        param = jsonObject.toString();

        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");
        Assert.assertEquals(code,"0");

    }
}
