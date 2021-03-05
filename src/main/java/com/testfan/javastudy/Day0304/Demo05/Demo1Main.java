package com.testfan.javastudy.Day0304.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210305
 */
public class Demo1Main {
    public static void main(String[] args) {
        //正常的实现： 子类名称 对象名 = new 子类名称();
//        MyInterfaceImpl myInterface = new MyInterfaceImpl();
//        myInterface.methodAbs();

        //多态 左父右子,左边是接口,右边是实现类
//        MyInterface myInterface1 = new MyInterfaceImpl();
//        myInterface1.methodAbs();

        //匿名内部类
        MyInterface objA = new MyInterface() {
            @Override
            public void methodAbsA() {
                System.out.println("匿名内部类A1111111111的使用");
            }
            @Override
            public void methodAbsB() {
                System.out.println("匿名内部类A2222222222222的使用");
            }
        };
        objA.methodAbsA();
        objA.methodAbsB();

        new MyInterface(){
            @Override
            public void methodAbsA() {
                System.out.println("匿名内部类B111111的使用");
            }
            @Override
            public void methodAbsB() {
                System.out.println("匿名内部类B2222222222使用");
            }
        }.methodAbsA();
        new MyInterface(){
            @Override
            public void methodAbsA() {
                System.out.println("匿名内部类B111111的使用");
            }
            @Override
            public void methodAbsB() {
                System.out.println("匿名内部类B2222222222使用");
            }
        }.methodAbsB();
//        objB.methodAbsA();
//        objB.methodAbsB();
    }
}
