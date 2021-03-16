package com.testfan.javastudy.Day0315.Demo06;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 孙珑瑜
 * @version 20210316
 */
public class demo01Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");

        printArray(list1);
        System.out.println("===========================");
        printArray(list2);

//        ArrayList<?> list3 = new ArrayList<?>(); //不能创建对象使用
    }

    public static void printArray(ArrayList<?> list){//可以作为参数传递
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            Object ob = it.next();
            System.out.println(ob);
        }
    }
}
