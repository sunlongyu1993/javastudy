package com.testfan.javastudy.Day0225.Demo07.InterfaceAndExtend;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterface {
    public default void method(){
        System.out.println("接口的默认方法");
    }
}
