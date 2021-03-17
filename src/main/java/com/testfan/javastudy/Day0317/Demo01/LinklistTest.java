package com.testfan.javastudy.Day0317.Demo01;

import java.util.LinkedList;

/**
 * @author 孙珑瑜
 * @version 20210317
 * Linklist 集合的学习
 */
public class LinklistTest {
    public static void main(String[] args) {
//        show01();
//        show02();
        show03();
    }
    public static void show01(){
        LinkedList<String> linklist = new LinkedList<>();
        linklist.add("a");
        linklist.add("b");
        linklist.add("c");
        linklist.add("d");

        System.out.println(linklist);

        linklist.addFirst("www");
        System.out.println(linklist);
        linklist.push("http");
        System.out.println(linklist);


        linklist.addLast("com");
        System.out.println(linklist);
    }
    public static void show02(){
        LinkedList<String> linklist1 = new LinkedList<>();
        linklist1.add("a");
        linklist1.add("b");
        linklist1.add("c");
        linklist1.add("d");

//        linklist1.clear();
        if (!linklist1.isEmpty()){
            String first = linklist1.getFirst();
            System.out.println(first);
            String last = linklist1.getLast();
            System.out.println(last);
        }




    }
    public static void show03(){
        LinkedList<String> linklist1 = new LinkedList<>();
        linklist1.add("a");
        linklist1.add("b");
        linklist1.add("c");
        linklist1.add("d");




    }
}
