package com.testfan.javastudy.Day0319.Demo01;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 孙珑瑜
 * @version 20210319
 */
public class Demo01Collections {
    public static void main(String[] args) {
//        ArrayList<String > list = new ArrayList<>();
//        Collections.addAll(list,"a","b","c");
//        System.out.println(list);
//
//        Collections.shuffle(list);
//        System.out.println(list);

//        ArrayList<Integer > listint = new ArrayList<>();
//        Collections.addAll(listint,1,2,3,5,6,7,3,2);
////        System.out.println(listint);
//        Collections.sort(listint);
//        System.out.println(listint);

//        ArrayList<String > liststr = new ArrayList<>();
//        Collections.addAll(liststr,"a","c","d","e","b");
//        Collections.sort(liststr);
//        System.out.println(liststr);
        ArrayList<Person > listPerson = new ArrayList<>();
        listPerson.add(new Person(18,"张三"));
        listPerson.add(new Person(25,"李四"));
        listPerson.add(new Person(20,"王五"));

        System.out.println(listPerson);
        Collections.sort(listPerson);
        System.out.println(listPerson);
    }
}
