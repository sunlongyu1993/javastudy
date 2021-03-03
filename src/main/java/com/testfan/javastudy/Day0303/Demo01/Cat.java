package com.testfan.javastudy.Day0303.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    //子类特有方法
    public void catchMouse(){
        System.out.println("猫捉老鼠");
    }
}
