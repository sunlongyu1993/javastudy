package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmAddContactsServer;
import com.testfan.MavenStudy.apistudy.server.CrmAddCustomerServer;
import com.testfan.MavenStudy.apistudy.server.CrmDeleteCustomerServer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
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
}
