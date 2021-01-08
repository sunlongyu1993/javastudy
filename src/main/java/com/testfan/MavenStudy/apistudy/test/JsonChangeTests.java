package com.testfan.MavenStudy.apistudy.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author 孙珑瑜
 * @version 20210108
 */
public class JsonChangeTests {

    public static void main(String[] args) throws FileNotFoundException {
        // 从文件中读取内容
        JSONReader jsonReader = new JSONReader(new FileReader(new File("src/main/resources/crmparams/addCustomer.json")));
       // 将读取的内容转为jsonobject
        JSONObject readObject = jsonReader.readObject(JSONObject.class);
        System.out.println(readObject.toJSONString());
        // 修改内容
        JSONPath.set(readObject,"$.entity.customer_name","客户sly");
        System.out.println(readObject.toJSONString());

        //删除字段
        JSONPath.remove(readObject,"$.entity.lat");
        System.out.println(readObject.toJSONString());
    }
}
