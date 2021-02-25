package com.testfan.javastudy.Day0225.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public interface MyInterfaceDefault {
    public abstract void methodA();//抽象方法


//    public abstract void methodB();//新增一个抽象方法
    public default void methodC(){//默认方法，java8以后新增，为了接口升级问题
        System.out.println("接口中新增一个默认方法，于此相关的实现类就不用覆盖重写此方法了");
    }
    default void methodDefault(){
        System.out.println("接口中新增一个默认方法,没有public也是默认方法");

    }

}
