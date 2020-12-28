package com.testfan.MavenStudy.apistudy.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
/**
 * @author 孙珑瑜
 * @version 20201228
 */
//token
public class CrmTest {
    String token;
    @Test
    public void test001_login(){
        token = given()
                .formParam("username", "admin")
                .formParam("password", "123456")
                .log().all()
                .when()
                .post("http://192.168.23.129:8090/login")
                .then()
                .log().all()
                .statusCode(200)
                .body("code", equalTo(0))
                .extract().jsonPath().getString("Admin-Token");
        System.out.println(token);


    }
    //新增客户
    @Test(dependsOnMethods = "test001_login")
    public void test002_addCustomer(){
        given()
                .body("{  \"entity\": {\n" +
                        "        \"customer_name\": \"客户\",\n" +
                        "        \"mobile\": \"18810677201\",\n" +
                        "        \"telephone\": \"18810677201\",\n" +
                        "        \"website\": \"http://testfan.cn\",\n" +
                        "        \"next_time\": \"2020-12-31 00:00:00\",\n" +
                        "        \"remark\": \"备注\",\n" +
                        "        \"address\": \"北京市,北京市,朝阳区\",\n" +
                        "        \"detailAddress\": \"地铁14号线东段将台\",\n" +
                        "        \"location\": \"地铁14号线东段将台\",\n" +
                        "        \"lng\": 116.49652995682115,\n" +
                        "        \"lat\": 39.976969081085144\n" +
                        "    }}")
                .contentType(ContentType.JSON)
                .header("Admin-Token",token)
                .log().all()
                .when()
                    .post("http://192.168.23.129:8090/CrmCustomer/addOrUpdate")
                .then()
                .log().all()
                .statusCode(200);
    }
}
