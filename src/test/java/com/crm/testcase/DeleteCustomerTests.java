package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmAddContactsServer;
import com.testfan.MavenStudy.apistudy.server.CrmAddCustomerServer;
import com.testfan.MavenStudy.apistudy.server.CrmDeleteCustomerServer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20210122
 */
public class DeleteCustomerTests extends TestBase {

    @Test(description = "删除客户——没有任何关联")
    public void test001_deleCustomer() throws Exception {
        //新建一个客户，然后删除客户
        String addCustomer = CrmAddCustomerServer.AddCustomer(host, token);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code = JSONPath.extract(addCustomer, "$.code");
        Assert.assertEquals(code,0);
        Object customerId = JSONPath.extract(addCustomer, "$.data.customerId");
        System.out.println("customerId:"+customerId.toString());

        //调用删除的业务层接口方法
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("customerIds",customerId);
        String deleteCustomer = CrmDeleteCustomerServer.DeleteCustomer(host, token,updatapraram);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code1 = JSONPath.extract(deleteCustomer, "$.code");
        Assert.assertEquals(code1,0);
    }

    @Test(description = "删除客户——客户与联系人进行了关联")
    public void test002_deleCustomer() throws Exception {
        //新建一个客户，然后删除客户
        String addCustomer = CrmAddCustomerServer.AddCustomer(host, token);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code = JSONPath.extract(addCustomer, "$.code");
        Assert.assertEquals(code,0);
        //获取新建客户中的customerId
        Object customerId = JSONPath.extract(addCustomer, "$.data.customerId");
        System.out.println("customerId:"+customerId.toString());

        //新建联系人，并将客户和联系人进行关联
        Map<Object,Object> needupdataparam = new HashMap<Object,Object>();
        needupdataparam.put("$.entity.customer_id",customerId);
        String addContacts = CrmAddContactsServer.AddContacts(host, token, needupdataparam);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code1 = JSONPath.extract(addContacts, "$.code");
        Assert.assertEquals(code1,0);

        //调用删除的业务层接口方法
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("customerIds",customerId);//注意，表单类型的参数，直接put，参数名称即可
        String deleteCustomer2 = CrmDeleteCustomerServer.DeleteCustomer(host, token,updatapraram);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code2 = JSONPath.extract(deleteCustomer2, "$.code");
        String msg = JSONPath.extract(deleteCustomer2, "$.msg").toString();
        Assert.assertEquals(code2,500);
        Assert.assertEquals(msg,"该条数据与其他数据有必要关联，请勿删除");
    }

    @Test(description = "删除客户——删除多个没有任何关联的客户")
    public void test003_deleCustomer() throws Exception {
        String addCustomer1 = CrmAddCustomerServer.AddCustomer(host, token);   //新建一个客户
        String customerId1 = JSONPath.extract(addCustomer1, "$.data.customerId").toString();   //获取新建客户中的customerId
        String addCustomer2 = CrmAddCustomerServer.AddCustomer(host, token);
        String customerId2 = JSONPath.extract(addCustomer2, "$.data.customerId").toString();

        System.out.println("customerId1:"+customerId1.toString());
        System.out.println("customerId2:"+customerId2.toString());

        //调用删除的业务层接口方法
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("customerIds",customerId1+","+customerId2);//注意，表单类型的参数，直接put，参数名称即可,拼接入参
        String deleteCustomer2 = CrmDeleteCustomerServer.DeleteCustomer(host, token,updatapraram);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code2 = JSONPath.extract(deleteCustomer2, "$.code");
        Assert.assertEquals(code2,0);
    }

    @Test(description = "删除客户——删除其他测试中的已经关联的客户")
    public void test004_deleCustomer() throws Exception {
//        1、新建客户；
//        2、新建联系人，并将联系人和客户进行关联；
//        3、删除已经关联的客户；


        //调用删除的业务层接口方法
        Map<Object,Object> updatapraram = new HashMap<Object,Object>();
        updatapraram.put("customerIds",customerId1+","+customerId2);//注意，表单类型的参数，直接put，参数名称即可,拼接入参
        String deleteCustomer2 = CrmDeleteCustomerServer.DeleteCustomer(host, token,updatapraram);
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        Object code2 = JSONPath.extract(deleteCustomer2, "$.code");
        Assert.assertEquals(code2,0);
    }
}
