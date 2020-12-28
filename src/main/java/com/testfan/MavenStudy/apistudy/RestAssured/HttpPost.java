package com.testfan.MavenStudy.apistudy.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
/**
 * @author 孙珑瑜
 * @version 20201228
 */
public class HttpPost {
    @Test//表单类型的post
    public void test001_PostForm(){
        given()//网络请求所需要的条件都写在这里，头信息、query参数
                .formParam("userName","admin")
                .formParam("password","1234")
                .log().all()////请求日志
                .when()//触发条件
                    .post("http://192.168.23.129:8080/pinter/com/login")
                .then()//断言
                    .log().all()//响应日志
                    .statusCode(200)//断言响应状态码200
                    .body("code",equalTo("0"))//断言响应中的code字段等于0
                    .body("message",equalTo("success"));
    }

    @Test//json 格式的参数
    public void test002_PostJson(){
        given()//网络请求所需要的条件都写在这里，头信息、query参数
                .body("{\"userName\":\"test\",\"password\":\"1234\",\"gender\":1,\"phoneNum\":\"110\",\"email\":\"beihe@163.com\",\"address\":\"Beijing\"}")
                .contentType(ContentType.JSON)//指定contentType
                .log().all()//请求日志
                .when()//触发条件
                    .post("http://192.168.23.129:8080/pinter/com/register")
                .then()//断言
                    .statusCode(200)//断言响应状态码200
                    .log().all()//响应日志
                    .body("code",equalTo("0"))//断言响应中的code字段等于0
                    .body( "message",equalTo("注册成功"));//断言message字段是否等于注册成功
    }

    @Test//xml 格式的参数
    public void test003_PostXml(){
        String getMobileCodeInfoResult = given()//网络请求所需要的条件都写在这里，头信息、query参数
                .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "  <soap:Body>\n" +
                        "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                        "      <mobileCode>18810677206</mobileCode>\n" +
                        "      <userID></userID>\n" +
                        "    </getMobileCodeInfo>\n" +
                        "  </soap:Body>\n" +
                        "</soap:Envelope>")
                .headers("Content-Type", "text/xml")//添加header
                .log().all()//请求日志
                .when()//触发条件
                    .post("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx")
                .then()//断言
                    .log().all()//响应日志
                    .statusCode(200)//断言响应状态码200
                    .extract().xmlPath().get("getMobileCodeInfoResult").toString();// 通过extract 的方法来获取到对应的数据
            Assert.assertEquals(getMobileCodeInfoResult,"18810677206：北京 北京 北京移动全球通卡");
    }
    @Test//xml 格式的参数
    public void test004_PostXml(){
        given()//网络请求所需要的条件都写在这里，头信息、query参数
                .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "  <soap:Body>\n" +
                        "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                        "      <mobileCode>18810677206</mobileCode>\n" +
                        "      <userID></userID>\n" +
                        "    </getMobileCodeInfo>\n" +
                        "  </soap:Body>\n" +
                        "</soap:Envelope>")
                .headers("Content-Type", "text/xml")//添加header
                .log().all()//请求日志
                .when()//触发条件
                .post("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx")
                .then()//断言
                .log().all()//响应日志
                .statusCode(200)//断言响应状态码200
                .body("getMobileCodeInfoResult",contains("18810677206：北京 北京 北京移动全球通卡"));
            }
}