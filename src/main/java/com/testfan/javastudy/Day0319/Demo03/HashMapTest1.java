package com.testfan.javastudy.Day0319.Demo03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20210322
 */
public class HashMapTest1 {
    public static void main(String[] args) {
//        demo01();
        demo02();
    }

//    public static void demo01(){
//        Map<String,Person> map = new HashMap<>();
//        map.put("北京",new Person("sly1",18));
//        map.put("上海",new Person("sly2",19));
//        map.put("广州",new Person("sly3",20));
//        map.put("北京",new Person("sly4",21));
//
//        for (Map.Entry<String, Person> entryset : map.entrySet()) {
//            System.out.println(entryset.getKey()+entryset.getValue());
//        }
//    }
    public static void demo02(){
        Map<Person,String> map = new HashMap<>();
        map.put(new Person("sly1",18),"北京");
        map.put(new Person("sly2",19),"上海");
        map.put(new Person("sly2",19),"广州");
        map.put(new Person("sly3",20),"广州");

        for (Map.Entry<Person, String> entryset : map.entrySet()) {
            System.out.println(entryset.getKey()+entryset.getValue());
        }
    }

}
