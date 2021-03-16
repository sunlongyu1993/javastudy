package com.testfan.javastudy.Day0315.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210316
 * 实现类1
 * 方法一
 */
public class GenericInterfaceImpl implements GenericInterface<String>{

    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
