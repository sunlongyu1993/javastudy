package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmAddCustomerServer;
import com.testfan.MavenStudy.apistudy.server.CrmLoginServer;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20210121
 */
//crm 登录的测试用例
public class AddCustomerTests {
    public static String host = "http://192.168.23.135:8090";

    @Test
    public void test001_AddCustomer() throws Exception {
        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code = JSONPath.extract(login, "$.code").toString();
        Assert.assertEquals(code,"0");
        String token = JsonPath.from(login).get("Admin-Token");//获取到token

        String AddCustomer = CrmAddCustomerServer.AddCustomer(host, token);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
}
