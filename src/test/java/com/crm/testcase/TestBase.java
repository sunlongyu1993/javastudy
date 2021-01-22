package com.crm.testcase;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.server.CrmLoginServer;
import com.testfan.MavenStudy.apistudy.utils.DButil;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

/**
 * @author 孙珑瑜
 * @version 20210122
 */
public class TestBase {
    public static String host = "http://192.168.23.135:8090";
    public static String token;

    @BeforeClass
    public void init() throws Exception {
        String login = CrmLoginServer.login(host);// 获取响应结果，进行断言
        Assert.assertEquals(MyHttpMethod.getStatusCode(),200);
        String code = JSONPath.extract(login, "$.code").toString();
        Assert.assertEquals(code,"0");
        token = JsonPath.from(login).get("Admin-Token");//获取到token

        //数据库的初始化,读取
        String url = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.url");
        String dbusername = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.user");
        String dbpwd = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxcrm.jdbc.pwd");
        DButil.getconn(url,dbusername,dbpwd);
    }
    @AfterClass
    public void afterclass() throws SQLException {
        DButil.close();
    }

}
