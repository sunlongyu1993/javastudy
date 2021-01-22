package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmLoginServer;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20210121
 */
//crm 登录的测试用例
public class LoginTests {
    public static String host = "http://192.168.23.135:8090";
    @Test
    public void test001_login() throws Exception {
        //不用调用post方法，进行请求，直接调用业务层的方法就可以了
        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code = JSONPath.extract(login, "$.code").toString();
        Assert.assertEquals(code,"0");
        String Admin_Token = JsonPath.from(login).get("Admin-Token");//获取到token
        System.out.println(Admin_Token);
    }
}
