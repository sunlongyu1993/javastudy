package com.testfan.javastudy.Day0225.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class Demo01Interface {
    public static void main(String[] args) {
        //接口默认方法的使用
        //默认方法会被实现类继承
        MyInterfaceDefaultA myInterfaceDefaultA = new MyInterfaceDefaultA();
        myInterfaceDefaultA.methodA();//抽象方法
        myInterfaceDefaultA.methodC();//默认方法
        myInterfaceDefaultA.methodDefault();//实现类A直接调用了接口中的默认方法，不用覆盖重新接口中的默认方法



        MyInterfaceDefaultB myInterfaceDefaultB = new MyInterfaceDefaultB();
        myInterfaceDefaultB.methodDefault();//实现类B覆盖重新了接口中的默认方法
    }
}
