package com.testfan.javastudy.Day0317.Demo02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210318
 */
public class Demo01Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);

//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
