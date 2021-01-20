package com.testfan.MavenStudy.apistudy.HttpClient.Mtx;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class MtxShopTest_Excel {
    String ip;
    Map<Object,Object> param;
    Map<Object,Object> header;

    @BeforeClass
    public void init() throws Exception {
        ip ="http://192.168.23.135";
        param = new HashMap<>();
        header = new HashMap<>();
        header.put("X-Requested-With","XMLHttpRequest");
    }

    @DataProvider
    public Object[][] getRegData() throws Exception {
        ExcelUtil excelUtil=new ExcelUtil("src/main/resources/datadriver/mtxshop.xlsx");
        Object[][] sheetData = excelUtil.getSheetData("reg");
        excelUtil.close();
        return sheetData;
    }

    @Test(dataProvider = "getRegData")//商城登录接口，从Excel 中读取数据
    public void test001_reg(String casename,String accounts,String pwd,String type,String is_agree_agreement,String assertvalue) throws Exception {
        param.put("accounts",accounts);
        param.put("pwd",pwd);
        param.put("type",type);
        param.put("is_agree_agreement",is_agree_agreement);

        //发送请求
        String res = MyHttpMethod.PostForm(ip + "/mtx/index.php?s=/index/user/reg.html", param, header);
        //断言接口响应值
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        //断言是否注册成功
        String msg = JsonPath.from(res).getString("msg");//方法一
        Assert.assertEquals(msg,assertvalue);

    }
}
