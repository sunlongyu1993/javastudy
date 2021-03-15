package com.testfan.javastudy.Day0315.Demo03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 孙珑瑜
 * @version 20210315
 * Collection集合
 */
public class Demo01Collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);
        coll.add("abc");
        coll.add("111");
        coll.add("张三");
        coll.add("李四");
        System.out.println(coll);

        coll.remove("张三");
        System.out.println(coll);

        boolean aaa = coll.contains("李四");
        System.out.println(aaa);

        boolean empty = coll.isEmpty();
        System.out.println(empty);

        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
