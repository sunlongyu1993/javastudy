package com.testfan.javastudy.Day0304.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210305
 */
public class Demo1Main {
    public static void main(String[] args) {
//        MyInterfaceImpl myInterface = new MyInterfaceImpl();
//        myInterface.methodAbs();

        //多态 左父右子,右边是实现类，左边是接口
        MyInterface myInterface1 = new MyInterfaceImpl();
        myInterface1.methodAbs();
    }
}
