package com.testfan.javastudy.Day0416.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 递归
 */
public class DiguiStudy01 {
    public static void main(String[] args) {
//        a();
        b(1);
    }

    private static void b(int i) {
        System.out.println("b方法"+i);
        if (i==50000){
            return;
        }
        b(++i);
    }

    private static void a() {
        System.out.println("a方法");
        a();
    }
    public DiguiStudy01(){
//        DiguiStudy01();
        }


}
