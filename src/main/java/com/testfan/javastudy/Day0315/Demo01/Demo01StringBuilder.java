package com.testfan.javastudy.Day0315.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210315
 */
public class Demo01StringBuilder {
    public static void main(String[] args) {
//        StringBuilder s1 = new StringBuilder();
//        System.out.println(s1);
//
//        StringBuilder s2 = new StringBuilder("abc");
//        System.out.println(s2);

        StringBuilder bu3 = new StringBuilder();
        StringBuilder bu4 = bu3.append("bbb");
        System.out.println(bu3);
        System.out.println(bu4);

        System.out.println(bu3 == bu4);
    }

}
