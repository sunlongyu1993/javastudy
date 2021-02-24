package com.testfan.javastudy.day0220.staticstudy;

/**
 * @author 孙珑瑜
 * @version 20210223
 */
public class Demo02Math {
    public static void main(String[] args) {
        //获取绝对值
        System.out.println(Math.abs(3.24));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-4.5));
        System.out.println("============================");
        System.out.println(Math.ceil(3.9));
        System.out.println(Math.ceil(3.1));
        System.out.println(Math.ceil(3.0));
        System.out.println("============================");
        System.out.println(Math.floor(3.5));
        System.out.println(Math.floor(3.9));
        System.out.println(Math.floor(3.0));
        System.out.println("==================");
        System.out.println(Math.round(20.4));
        System.out.println(Math.round(10.5));
        System.out.println(Math.PI);
    }
}
