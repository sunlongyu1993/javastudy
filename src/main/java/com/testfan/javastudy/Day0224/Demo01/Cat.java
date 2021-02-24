package com.testfan.javastudy.Day0224.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class Cat extends Animal{
    @Override
    public void eat(){//子类中将父类的抽象方法去掉abstract
        System.out.println("子类要覆盖重写抽象父类中所有的抽象方法");
    }
}
