package com.testfan.javastudy.Day0315.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210316
 * 实现类2
 * 方法2：接口使用什么类型的泛型，实现类就使用什么类型的泛型，类跟着接口走
 */
public class GenericInterfaceImpl2<I> implements GenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
