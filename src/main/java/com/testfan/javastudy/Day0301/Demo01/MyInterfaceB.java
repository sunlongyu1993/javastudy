package com.testfan.javastudy.Day0301.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterfaceB {
    public abstract void methodB();
    public abstract void Commonmethod();

    public default void methodDefault(){
        System.out.println("接口中默认方法BBB");
    }

}
