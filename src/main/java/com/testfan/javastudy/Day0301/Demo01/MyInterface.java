package com.testfan.javastudy.Day0301.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterface extends MyInterfaceA,MyInterfaceB{
    public abstract void method();

    @Override
    default void methodDefault() {
    }
}
