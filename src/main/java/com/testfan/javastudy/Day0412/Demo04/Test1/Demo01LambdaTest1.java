package com.testfan.javastudy.Day0412.Demo04.Test1;

/**
 * @author 孙珑瑜
 * @version 20210412
 * Lambda练习1 无参无返回值
 */
public class Demo01LambdaTest1 {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("匿名内部类吃饭了");
            }
        });
        System.out.println("=========================");
        invokeCook(
                ()->{
                    System.out.println("Lambda,吃饭了");
                }
        );
        System.out.println("Lambda省略版本");
        invokeCook(
                ()->System.out.println("Lambda,吃饭了")
        );

    }
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}
