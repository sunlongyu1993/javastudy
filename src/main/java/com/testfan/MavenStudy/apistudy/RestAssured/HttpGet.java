package com.testfan.MavenStudy.apistudy.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

/**
 * @author 孙珑瑜
 * @version 20201228
 */
public class HttpGet {
    @Test
    public  void test001_Get(){
        // 方式一
        String str = given()
                .queryParam("id", "1").log().all()
                .when()
                .get("http://192.168.23.135:8080/pinter/com/getSku")
                .then()
                .log().all()
                .statusCode(200)
                .extract().asString();
//        System.out.println(str);
        Assert.assertTrue(str.contains("success"));
    }
//    {
//        "code": "0",
//            "message": "success",
//            "data": {
//        "skuId": 1,
//                "skuName": "ptest-1",
//                "price": "55",
//                "stock": 130,
//                "brand": "testfan"
//    }
//    }
    @Test
    public  void test002_Get(){
//        方式二
        given().queryParam("id", "1").log().all()
                .when()
                .get("http://192.168.23.135:8080/pinter/com/getSku")
                .then()
                .statusCode(200)
                .body("message",equalTo("success"))
                .body("data.stock",lessThanOrEqualTo(1000))
                .body("data.skuName",equalTo("ptest-1"));// jsonpath

    }
}
