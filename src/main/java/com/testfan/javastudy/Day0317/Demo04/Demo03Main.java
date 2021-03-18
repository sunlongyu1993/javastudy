package com.testfan.javastudy.Day0317.Demo04;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author 孙珑瑜
 * @version 20210318
 */
public class Demo03Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("www");
        set.add("com");
        System.out.println(set);


        LinkedHashSet<String> linke = new LinkedHashSet<>();
        linke.add("abc");
        linke.add("abc");
        linke.add("www");
        linke.add("com");
        System.out.println(linke);

    }
}
