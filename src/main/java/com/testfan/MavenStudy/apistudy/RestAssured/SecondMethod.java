package com.testfan.MavenStudy.apistudy.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20201228
 */
public class SecondMethod {
    @Test
    public void test001_get(){
        RequestSpecification request = RestAssured.given();
        //添加参数
        request.queryParam("id","1");
        request.log().all();
        //发起请求
        Response response = request.get("http://192.168.23.135:8080/pinter/com/getSku");
        response.then().log().all();
        // 断言
        request.then().statusCode(200);

        String res = response.asString();
//        Assert.assertTrue(res.contains("message"));
        String message = JsonPath.from(res).getString("message");
        Assert.assertEquals(message,"success");
    }
}
