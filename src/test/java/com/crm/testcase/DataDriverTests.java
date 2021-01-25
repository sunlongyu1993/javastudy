package com.crm.testcase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210125
 */
public class DataDriverTests extends TestBase {

    @DataProvider
    public Object[][] getCrmData() throws Exception {
        ExcelUtil excelUtil = new ExcelUtil("src/main/resources/datadriver/crmdata.xlsx");
        Object[][] sheetData = excelUtil.getSheetData("crm");
        excelUtil.close();
        return sheetData;
    }
    @Test(dataProvider = "getCrmData")
    public void Test(String casename,String interfaceName,String url,String method,String headers,String prams,String assertvalue) throws IOException {
        //将header从json 转为map 对象
        JSONObject headerjson = JSONObject.parseObject(headers);
        Map headersmaps = headerjson.toJavaObject(Map.class);//转化为map 对象
        headersmaps.put("Admin-Token", token);
        //将prams从json 转为map 对象
        JSONObject pramsjson = JSONObject.parseObject(prams);
        //将assertvalue从json 转为map 对象
        JSONObject assertvaluejson = JSONObject.parseObject(assertvalue);
        Map assertmaps = assertvaluejson.toJavaObject(Map.class);

        String resString ="";//用来接收接口请求的返回值
        if(method.equalsIgnoreCase("get")){}
        else if(method.equalsIgnoreCase("post")){
            resString= MyHttpMethod.PostJson(host+url, pramsjson, headersmaps);
        }
        //循环遍历断言
        Set<Map.Entry<String, Object>> entrySet = assertmaps.entrySet();
        for (Map.Entry<String, Object> s:entrySet) {
            String key = s.getKey();
            Object value = s.getValue();
            Object extractvalue = JSONPath.extract(resString, "$." + key);//根据断言中的key,获取到断言的value
            Assert.assertEquals(value,extractvalue);
        }
    }
}
