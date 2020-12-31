package com.testfan.MavenStudy.apistudy.HttpClient;

import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class MtxShopTestFZ {
    String ip;
    Map<Object,Object> param;
    Map<Object,Object> header;

    @BeforeClass
    public void init(){
        ip ="http://192.168.23.129";
        param = new HashMap<>();
        header = new HashMap<>();
        header.put("X-Requested-With","XMLHttpRequest");
    }

    @Test//商城登录接口
    public void test001_login() throws Exception {
//        Map<Object,Object> param = new HashMap<>();
        param.put("accounts","slytest");
        param.put("pwd","123456");
//        Map<Object,Object> header = new HashMap<>();
//        header.put("X-Requested-With","XMLHttpRequest");
        String res = MyHttpMethod.PostForm(ip + "/mtx/public/index.php?s=/index/user/login.html", param, header);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String msg = JsonPath.from(res).getString("msg");
        Assert.assertEquals(msg,"登录成功");
    }
    @Test//上传头像接口
    public void test002_uploadavater() throws Exception {
//        Map<Object,Object> header = new HashMap<>();
//        header.put("X-Requested-With","XMLHttpRequest");
//        Map<Object,Object> param = new HashMap<>();
        param.put("img_x","43");
        param.put("img_y","91");
        param.put("img_width","346");
        param.put("img_height","346");
        param.put("img_rotate","0");
        param.put("file","C:\\Users\\sunlongyu\\Pictures\\Camera Roll\\1.jpg");
        String resupload = MyHttpMethod.upload(ip + "/mtx/index.php?s=/index/user/useravatarupload.html", param, header);
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String msg = JsonPath.from(resupload).getString("msg");
        Assert.assertEquals(msg,"上传成功");


    }

}
