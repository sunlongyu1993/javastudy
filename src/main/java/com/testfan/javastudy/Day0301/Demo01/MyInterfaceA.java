package com.testfan.javastudy.Day0301.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterfaceA {
    public abstract void methodA();
    public abstract void Commonmethod();

    public default void methodDefault(){
        System.out.println("接口中默认方法AAA");
    }
}
