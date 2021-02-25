package com.testfan.javastudy.Day0225.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class MyInterfaceDefaultB implements MyInterfaceDefault{
    @Override
    public void methodA() {
        System.out.println("实现接口的抽象方法BBB");
    }


    //覆盖重新接口中的默认方法
    @Override
    public void methodDefault() {
        System.out.println("实现类B覆盖重新接口中的默认方法");
    }
}
