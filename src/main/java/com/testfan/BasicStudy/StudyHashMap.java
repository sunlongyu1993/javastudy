package com.testfan.BasicStudy;

import java.util.*;

/**
 * @author 孙珑瑜
 * @version 20201010
 */
public class StudyHashMap {
    public static void main(String[] args) {
        HashMap<String,String> stu1 = new HashMap<String, String>();
        stu1.put("name","sly1");
        stu1.put("age","18");
        stu1.put("job","teacher");
//        System.out.println(stu1.get("name"));
//        System.out.println(stu1.get("age"));
//        System.out.println(stu1.get("job"));
//
//        stu1.put("name","sly2");
//        System.out.println(stu1.get("name"));
//
//        //判断hashmap 是否已经存在某个key
//        System.out.println(stu1.containsKey("name"));
//        // 删除key 是name的
//        stu1.remove("name");
//        //判断hashmap 是否已经存在某个key
//        System.out.println(stu1.containsKey("name"));

        //遍历所有的key值
//        Set<String> Stu1_key = stu1.keySet();
//        for (String stu1_key:stu1.keySet()) {
//            System.out.println(stu1_key);
//        }
        //遍历所有的value值
//        Collection<String> values = stu1.values();
//        for (String stu1_value:stu1.values()) {
//            System.out.println(stu1_value);
//        }
        //通过key,可以找到value
//        for (String stu1_key_get_value:stu1.keySet()) {
//            System.out.println("根据key 获取value:"+stu1.get(stu1_key_get_value));
//        }

        //遍历所有的key_value
//        Set<Map.Entry<String, String>> entries = stu1.entrySet();
//        for (Map.Entry<String, String> key_value:stu1.entrySet()) {
//            System.out.println(key_value);
//        }


    }
}
