package com.testfan.javastudy.Day0225.Demo07;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public class MyInterfaceImpl implements MyInterfaceA,MyInterfaceB{
    @Override
    public void abstractmethodA() {
        System.out.println("覆盖重新了A方法");
    }

    @Override
    public void abstractmethodB() {
        System.out.println("覆盖重新了B方法");
    }
    @Override
    public void methodabs() {
        System.out.println("接口A和接口B中的相同方法，只需要实现一次即可");
    }

    @Override
    public void methoddefault(){
        System.out.println("对多个接口中冲突的默认方法进行覆盖重写");
    }
}
