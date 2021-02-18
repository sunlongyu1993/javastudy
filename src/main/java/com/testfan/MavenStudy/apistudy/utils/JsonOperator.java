package com.testfan.MavenStudy.apistudy.utils;
import com.alibaba.fastjson.JSONObject;
//作为jmeter的第三方jar包引入
//作用：替换post请求中入参是json格式
public class JsonOperator {
    public  String  replaceJson(String jsonparm, String keyString, String replacevalue){
        JSONObject tempparam = JSONObject.parseObject(jsonparm);
        JSONObject entityparam = tempparam.getJSONObject("entity");
        entityparam.replace(keyString,replacevalue);
        System.out.println("替换后的entityparam"+entityparam);

        String newJsonparm ="{ \"entity\":" +entityparam+"}";
        System.out.println("拼接后的newJsonparm"+newJsonparm);
        return newJsonparm;
    }

    public static void main(String[] args) {

    }
}
