package com.testfan.javastudy.Day0304.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210305
 */
public class MyOuter {
    public void methodOuter(){
        /*final */int num =10;//所在方法的局部变量

        class MyInner{//局部内部类

            public void methodInner(){
                System.out.println(num);
            }
        }

    }
}
