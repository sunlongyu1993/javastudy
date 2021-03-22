package com.testfan.javastudy.Day0319.Demo02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210322
 * map集合的遍历
 */
public class MapTest {
    public static void main(String[] args) {
        //map集合中的第一种
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",18);
        map.put("杨颖",19);
        map.put("杨幂",20);
        map.put("林志玲",21);

        Set<String> set = map.keySet();
        //第一种方法：迭代器
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()){
//            String key = it.next();
//            Integer value = map.get(key);
//            System.out.println(key+value);
//        }
        System.out.println("================");
        //第二种方法：增强for循环
//        for (String keyset : set) {
//            Integer values = map.get(keyset);
//            System.out.println(values);
//        }
        //优化增强for循环
        for (String keystr : map.keySet()) {
            Integer val = map.get(keystr);
            System.out.println(val);
        }
    }
}
