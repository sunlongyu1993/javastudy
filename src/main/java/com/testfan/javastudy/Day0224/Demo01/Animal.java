package com.testfan.javastudy.Day0224.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public abstract class Animal {//抽象方法所在的类叫抽象类
    public abstract void  eat();//抽象方法，没有大括号，因为抽象方法没有具体内容

    //可以定义普通方法
    public void normalMethod(){
        System.out.println("普通的成员方法");
    }
}
