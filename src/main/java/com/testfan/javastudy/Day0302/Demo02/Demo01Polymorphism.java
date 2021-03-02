package com.testfan.javastudy.Day0302.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210302
 */
public class Demo01Polymorphism {
    public static void main(String[] args) {
        Fu obj = new Zi();
//        System.out.println(obj.num);
//        System.out.println(obj.age);父类不会向下寻找
//        obj.showNum();//子类没有覆盖重新，就是Fu 10;
        obj.showNum();//子类覆盖重写父类方法，就是zi 20;
    }
}
