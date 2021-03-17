package com.testfan.javastudy.Day0317.Demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210317
 * List 集合常用的方法
 */
public class Demo01ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(list);

//        list.add(2,"itaaa");
//        System.out.println(list);
//
//        String remove = list.remove(2);
//        System.out.println(remove);
//        System.out.println(list);
//
//        String a = list.set(3, "A");
//        System.out.println(a);
//        System.out.println(list);
//
//        for (int i = 0; i <list.size() ; i++) {
//            String s = list.get(i);
//            System.out.println(s);
//        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
