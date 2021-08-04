package com.testfan.javastudy.Day0719.Demo01;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 210719
 * 方法的调用
 */
public class Methodtest {
    public static void main(String[] args) {
//        int a=2;
//        int b=3;
//        System.out.println(a ==b ? a:b);
        Scanner sc = new Scanner(System.in);
        int exnum=(int)(Math.random()*6)+1;//[1,7)
        int a = sc.nextInt();
        guessNum(a,exnum);
    }
    public static void guessNum(int a,int b){
        System.out.println(a ==b ? a:b);
    }
}
