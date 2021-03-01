package com.testfan.javastudy.Day0225.Demo05;

/**
 * @author 孙珑瑜
 */
public class MyInterfacePrivateAImpl implements MyInterfacePrivateA{
    public void methodAnother(){
        System.out.println("实现类专有的方法");
        MethodCommon();//实现类中访问到了接口中的默认方法
    }
}
