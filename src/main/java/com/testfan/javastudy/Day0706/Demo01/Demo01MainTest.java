package com.testfan.javastudy.Day0706.Demo01;

/**
 * @author 孙珑瑜
 * @version 210707
 */
public class Demo01MainTest {
    public static void show(MyFunctionInterface myfun){
        myfun.method1();
    }
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface = new MyFunctionInterfaceImpl();
        show( myFunctionInterface);
        show( new MyFunctionInterfaceImpl());

        show(new MyFunctionInterface() {
            @Override
            public void method1() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        show(()->{
            System.out.println("Lambda表达式重写接口中的抽象方法");
        });
    }
}
