package com.testfan.javastudy.Day0303.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    public void watchHose(){
        System.out.println("狗看家");
    }
}
