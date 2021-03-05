package com.testfan.javastudy.Day0304.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210305
 */
public class Outer {
    public void methodOuter(){
        class Inner{//局部内部类
            int num = 10;
            public void methodInner(){
                System.out.println(num);//10
                System.out.println("使用局部内部类");
            }
        }
        //使用局部内部类
        Inner inner = new Inner();
        inner.methodInner();
    }
}
