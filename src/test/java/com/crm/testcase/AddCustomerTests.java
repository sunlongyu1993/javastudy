package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmAddCustomerServer;
import com.testfan.MavenStudy.apistudy.server.CrmLoginServer;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20210121
 */
//crm 登录的测试用例
public class AddCustomerTests extends TestBase {
//    public static String host = "http://192.168.23.135:8090";

    @Test(description = "正确创建客户")
    public void test001_AddCustomer()  throws Exception {
//        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
//        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
//        String code = JSONPath.extract(login, "$.code").toString();
//        Assert.assertEquals(code,"0");
//        String token = JsonPath.from(login).get("Admin-Token");//获取到token
        //读取入参中的json参数
        String Addcustomer = CrmAddCustomerServer.AddCustomer(host, token);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(Addcustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "修改入参中的客户名称")
    public void test002_AddCustomer() throws Exception {
//        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
//        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
//        String code = JSONPath.extract(login, "$.code").toString();
//        Assert.assertEquals(code,"0");
//        String token = JsonPath.from(login).get("Admin-Token");//获取到token

        //修改读取入参中的json参数，再进行请求
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("$.entity.customer_name","客户sly");
        String AddCustomer = CrmAddCustomerServer.AddCustomer(host, token,updatapraram);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "删除入参中的location等多个字段")
    public void test003_AddCustomer() throws Exception {
//        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
//        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
//        String code = JSONPath.extract(login, "$.code").toString();
//        Assert.assertEquals(code,"0");
//        String token = JsonPath.from(login).get("Admin-Token");//获取到token
        //传入需要删除的字段，以数组的形势传入
        String[] deletedparam ={"$.entity.location","$.entity.lng"};
        String AddCustomer = CrmAddCustomerServer.AddCustomer(host, token,deletedparam);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "客户名称字段缺失")
    public void test004_AddCustomer() throws Exception {
        String[] deletedparam ={"$.entity.customer_name"};
        String AddCustomer = CrmAddCustomerServer.AddCustomer(host, token,deletedparam);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code1 = JSONPath.extract(AddCustomer, "$.code");
        Assert.assertEquals(code1,500);
    }
}
