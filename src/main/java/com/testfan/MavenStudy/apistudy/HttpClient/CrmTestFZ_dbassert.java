package com.testfan.MavenStudy.apistudy.HttpClient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.DButil;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
public class CrmTestFZ_dbassert {
    String ip;
    Map<Object,Object> header;
    String token;



    @BeforeClass
    public void init() throws Exception {
        ip = "http://192.168.23.129:8090";
        header = new HashMap<>();
        // 从数据库中读取内容
//        String url ="jdbc:mysql://192.168.23.129:3306/crm?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";
//        String dbusername = "root";
//        String dbpwd = "123456";
        String url = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.url");
        String dbusername = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.user");
        String dbpwd = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.pwd");
        DButil.getconn(url,dbusername,dbpwd);
    }

    @DataProvider
    public Object[][] getCustomerData(){
        Object[][] obj={
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

    /***新增客户——数据库断言
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

        //数据库断言，对应新增客户，使用参数中的客户名称和数据库中最新的客户名称进行对比
        String sql="SELECT customer_name FROM 72crm_crm_customer ORDER BY customer_id DESC LIMIT 1";
//        DButil.getconn(url,dbusername,dbpwd);//获取数据库连接对象
        List<Map<String, Object>> data = DButil.selectData(sql);//
        String act_customer_name = data.get(0).get("customer_name").toString();
//        String ext_customer_name= value;
        Assert.assertEquals(act_customer_name,value);
//        DButil.close();
    }
    /***客户列表查询接口——数据库断言
     * 读取参数，参数json类型
     * @throws IOException
     */
    @Test(dependsOnMethods = "test001_login",dataProvider = "getCustomerData")
    public void test003_queryPageList(String casename,String path,String value) throws Exception {
        //读取参数
        JsonPath from = JsonPath.from(new File("src/main/resources/crmparams/queryPageList.json"));
        String param = from.prettify();//转化成字符串
        int limit = from.getInt("limit");//从参数中取值来和sql 进行拼接
        //请求接口
        String response = MyHttpMethod.PostJsonOrXml(ip + "/CrmCustomer/queryPageList", param, header);
        int statusCode = MyHttpMethod.getStatusCode();// http的响应状态码
        Assert.assertEquals(statusCode,200);
        String code = JsonPath.from(response).getString("code");//开发自定义的表示业务的code 字段
        Assert.assertEquals(code,"0");
        //从相应结果中获取到数据
        //fastjson ，需要带$符号
        JSONArray customerNames = (JSONArray) JSONPath.extract(response, "$.data.list[*].customerName");
        JSONArray customerIds = (JSONArray) JSONPath.extract(response, "$.data.list[*].customerId");
//        for (Object s:customerNames) {
//            System.out.println(s);     }

        //        数据库断言：查询接口如何进行断言——
        String sql="SELECT customer_id,customer_name FROM 72crm_crm_customer ORDER BY create_time DESC limit "+limit;
//        DButil.getconn(url,dbusername,dbpwd);//获取数据库连接对象
        List<Map<String, Object>> data = DButil.selectData(sql);
//        for (Map<String, Object> s :data) {
//            System.out.println(s);}
        Assert.assertEquals(data.size(),customerIds.size());// 对比数据库中查到的数据总数和返回值中的数据总数进行比较，如果一致再进行下列操作
        for (int i = 0; i <data.size() ; i++) {
            //数据库中查询的为预期的
            Object ext_customer_name = data.get(i).get("customer_name");
            Object ext_customer_id = data.get(i).get("customer_id");
            //接口返回的为实际的
            Object act_customer_id = customerIds.get(i);
            Object act_customer_name = customerNames.get(i);
            Assert.assertEquals(act_customer_id,ext_customer_id);
            Assert.assertEquals(act_customer_name,ext_customer_name);
        }
//        DButil.close();

    }
    @AfterClass
    public void afterclass() throws SQLException {
        DButil.close();
    }
}
