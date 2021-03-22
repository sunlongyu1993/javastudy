package com.testfan.javastudy.Day0319.Demo02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210322
 */
public class MapTest2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",18);
        map.put("杨颖",19);
        map.put("杨幂",20);
        map.put("林志玲",21);

        Set<Map.Entry<String, Integer>> entrysets = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> it = entrysets.iterator();
//        while (it.hasNext()){
//            Map.Entry<String, Integer> next = it.next();
//            String key = next.getKey();
//            Integer value = next.getValue();
//            System.out.println(key+value);
//        }
        System.out.println("==========================");
        for (Map.Entry<String, Integer> entryset : entrysets) {
            System.out.println(entryset.getKey()+ entryset.getValue());
        }
    }
}
