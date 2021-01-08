package com.testfan.MavenStudy.apistudy.utils;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210107
 */
public class MyPropertisUtil {
    /**
     * 优化读取properties文件内容的脚本
     * @return
     */
    public static Map<Object, Object> getAll(String filename) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader(new File(filename)));
        Map<Object,Object> prama= new HashMap<>();
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry:entrySet) {
//            System.out.println(entry.getKey()+"="+entry.getValue());
            prama.put(entry.getKey(),entry.getValue());
        }
        return prama;
    }

    public static Map<String, Object> name() throws Exception {
        Properties properties= new Properties();
        //load 表示要加载一个流，new FileReader 读取某一个文件，
        properties.load(new FileReader(new File("src/main/resources/crmparams/crmlogin.properties")));
       // properties中有内容，就可以将文件内容读出
//        String username = properties.getProperty("username");
//        String password = properties.getProperty("password");
//        System.out.println(username);
//        System.out.println(password);

        Map<String,Object> prama= new HashMap<>();

        // 读取所有的内容
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry:entrySet) {
            System.out.println(entry.getKey()+"="+entry.getValue());

            // 因为读取的内容是set,但是参数是map,需要将set转为map
            prama.put(entry.getKey().toString(),entry.getValue());
        }
        return prama;
    }

    public static void main(String[] args) throws Exception {
        name();
    }
}
