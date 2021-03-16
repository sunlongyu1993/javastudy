package com.testfan.javastudy.Day0315.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210316
 */
public class demo02GenericMethod {
    //含有泛型的普通方法
    public <M> void method(M m){
        System.out.println(m);
    }
    //含有泛型的静态方法
    public static <M> void staticmethod(M m){
        System.out.println(m);//含有泛型的静态方法
    }
}
