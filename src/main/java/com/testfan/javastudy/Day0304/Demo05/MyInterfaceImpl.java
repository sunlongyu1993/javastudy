package com.testfan.javastudy.Day0304.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210305
 * 抽象方法的实现类
 */
public class MyInterfaceImpl implements MyInterface{

    @Override
    public void methodAbsA() {
        System.out.println("实现类覆盖重新抽象方法1111111111");
    }

    @Override
    public void methodAbsB() {
        System.out.println("实现类覆盖重新抽象方法2222222222222");

    }
}
