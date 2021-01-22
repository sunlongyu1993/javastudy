package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmAddContactsServer;
import com.testfan.MavenStudy.apistudy.server.CrmAddCustomerServer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20210121
 */
//crm 新增联系人接口的测试用例
public class AddContactsTests extends TestBase {
    @Test(description = "正确新建联系人")
    public void test001_AddContacts()  throws Exception {
        //读取入参中的json参数
        String AddCustomer = CrmAddContactsServer.AddContacts(host, token);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "修改入参中的customer_id为不存在的值")
    public void test002_AddContacts() throws Exception {
        //修改读取入参中的json参数，再进行请求
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("$.entity.customer_id","300000");
        String AddCustomer = CrmAddContactsServer.AddContacts(host, token,updatapraram);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "修改入参中的name为空的值")
    public void test003_AddContacts() throws Exception {
        //修改读取入参中的json参数，再进行请求
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("$.entity.name","");
        String AddCustomer = CrmAddContactsServer.AddContacts(host, token,updatapraram);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }
    @Test(description = "删除入参中的name、customer_id等多个字段")
    public void test004_AddContacts() throws Exception {
        String[] deletedparam ={"$.entity.name","$.entity.customer_id"};
        String AddCustomer =CrmAddContactsServer.AddContacts(host, token,deletedparam);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(AddCustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
    }

//    ==========================================================
    //多接口的组合场景:新增客户+添加联系人
    //获取新增客户中的customer_id，作为新增联系人接口的入参
    @Test(description = "创建客户和新增客户关联")
    public void test005_AddContacts() throws Exception {
        //先进行新增客户，从新增客户结果中获取最新的客户id
        String Addcustomer = CrmAddCustomerServer.AddCustomer(host, token);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code1 = JSONPath.extract(Addcustomer, "$.code").toString();
        Assert.assertEquals(code1,"0");
        Object customerId = JSONPath.extract(Addcustomer, "$.data.customerId");
//        System.out.println("customerId:"+customerId.toString());

        //然后将调用新增联系人接口
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("$.entity.customer_id",customerId);
        String Addcontacts = CrmAddContactsServer.AddContacts(host, token,updatapraram);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code2 = JSONPath.extract(Addcontacts, "$.code").toString();
        Assert.assertEquals(code2,"0");
    }

}
