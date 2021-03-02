package com.testfan.javastudy.Day0302.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210302
 */
public class Demo01Polymorphism {
    public static void main(String[] args) {
        Fu obj = new Zi();
        obj.method();//成员方法new 的是谁就优先调用谁
        obj.methodFu();
    }
}
