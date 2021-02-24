package com.testfan.javastudy.Day0224.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class Zi extends Fu{

    public Zi(){
        System.out.println("子类构造方法执行");
    }

    @Override
    public void eat() {
        System.out.println("子类覆盖重新抽象父类的抽象方法——吃饭饭");

    }
}
