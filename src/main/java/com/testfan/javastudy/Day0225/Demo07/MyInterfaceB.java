package com.testfan.javastudy.Day0225.Demo07;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterfaceB {
//    static {}
    public abstract void abstractmethodB();//抽象方法B
    public abstract void methodabs();
    public default void methoddefault(){
        System.out.println("接口B的默认方法A");
    }
}
