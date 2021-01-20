package com.testfan.MavenStudy.apistudy.HttpClient.Crm;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.DButil;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class CrmTestFZ_dataprovider {
    String ip;
    Map<Object,Object> header;
    String token;

    String url ="jdbc:mysql://192.168.23.129:3306/crm?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";
    String dbusername = "root";
    String dbpwd = "123456";

    @BeforeClass
    public void init(){
        ip = "http://192.168.23.129:8090";
        header = new HashMap<>();
    }

    @DataProvider
    public Object[][] getCustomerData(){
        Object[][] obj={
                {"客戶姓名为空","$.entity.customer_name",""},
                {"mobile为空","$.entity.mobile",""},
                {"website为空","$.entity.website",""},
                {"数据库断言","$.entity.customer_name","数据库断言"}
        };
        return obj;
    }

    @Test//登录
    public void test001_login() throws Exception {
        Map<Object, Object> param = MyPropertisUtil.getAll("src/main/resources/crmparams/mtxreg.properties");
//        param.put("username","sly");

        String response = MyHttpMethod.PostForm(ip + "/login", param, header);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String code = JsonPath.from(response).getString("code");
        Assert.assertEquals(code,"0");

        token = JsonPath.from(response).getString("Admin-Token");
        header.put("Admin-Token",token);
    }

    /***新增客户——客戶姓名为空
     * 读取参数，参数json类型
     * @throws IOException
     */
    @Test(dependsOnMethods = "test001_login",dataProvider = "getCustomerData")
    public void test002_addCustomer(String casename,String path,String value) throws Exception {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();

        JSONObject jsonObject = JSONObject.parseObject(param);
        JSONPath.set(jsonObject,path,value);
        param=jsonObject.toString();

        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");
    }
    /***新增客户——mobile为空
     * 读取参数，参数json类型
     * @throws IOException
     */
    @Test(dependsOnMethods = "test001_login",dataProvider = "getCustomerData")
    public void test003_addCustomer(String casename,String path,String value) throws IOException {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();

        //将参数进行转化
        JSONObject jsonObject = JSONObject.parseObject(param);
        //修改入参中的customer_name 为空
        JSONPath.set(jsonObject,path,value);
        //将替换后的jsonObject 重新赋值给param
        param = jsonObject.toString();

        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");
    }
    /***新增客户——website为空
     * 读取参数，参数json类型
     * @throws IOException
     */
    @Test(dependsOnMethods = "test001_login",dataProvider = "getCustomerData")
    public void test004_addCustomer(String casename,String path,String value) throws IOException {
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/addCustomer.json"));
        String param = from.prettify();
        JSONObject jsonObject = JSONObject.parseObject(param);
        JSONPath.set(jsonObject,path,value);
        param = jsonObject.toString();

        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/addOrUpdate", param, header);
        System.out.println(response);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);

        String code = JsonPath.from(response).getString("code");
        Assert.assertEquals(code,"0");

    }
}
