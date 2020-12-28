package com.testfan.MavenStudy.apistudy.RestAssured;

import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

/**
 * @author 孙珑瑜
 * @version 20201228
 */
// cookie
public class MtxShopTest {
    Map<String, String> cookies =null;
    @Test//登录
    public void test001_login(){
        cookies = given()
                .header("X-Requested-With", "XMLHttpRequest")
                .formParam("accounts", "slytest")
                .formParam("pwd", "123456")
                .when()
                .post("http://192.168.23.129/mtx/public/index.php?s=/index/user/login.html")
                .then()
                .log().all()
                .statusCode(200)
                .body("code", equalTo(0))
                .body("msg", equalTo("登录成功"))
                .extract().cookies();//获取cookie,并将cookie 传递给下一个接口
    }
    @Test
    public void test002_upload(){
        given()
                .cookies(cookies)
                .header("X-Requested-With","XMLHttpRequest")
                .multiPart("img_x","")
                .multiPart("img_x","")
                .multiPart("img_x","")
                .multiPart("img_x","")
                .multiPart("img_x","")
                .multiPart("file",new File("C:\\Users\\sunlongyu\\Pictures\\Camera Roll\\1.jpg"),"image/jpg")
                .when()
                    .post("http://192.168.23.129/mtx/index.php?s=/index/user/useravatarupload.html")
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
