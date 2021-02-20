package com.testfan.javastudy.day0220;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class Demo2Anonymous {
    public static void main(String[] args) {
        //普通使用方式
//        Scanner scanner = new Scanner(System.in);
//        String i = scanner.next();

//        匿名对象的方式
//        String num = new Scanner(System.in).next();
//        System.out.println(num);
        //使用一般写法传入参数
//        Scanner sc = new Scanner(System.in);
//        methodParam(sc);
        methodParam(new Scanner(System.in));//使用匿名对象来进行传参
    }
    public static void methodParam(Scanner sc){
        String num = sc.next();
        System.out.println("输入的是："+num);
    }
}
