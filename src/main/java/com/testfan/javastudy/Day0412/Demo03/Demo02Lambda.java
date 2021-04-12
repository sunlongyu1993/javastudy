package com.testfan.javastudy.Day0412.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210412
 * Lambda
 */
public class Demo02Lambda {
    public static void main(String[] args) {
        new Thread(//使用匿名内部类实现多线程
                new Runnable()
                {
                    @Override
                    public void run() { System.out.println(Thread.currentThread().getName() +"创建了一个新的线程1"); }
                }
                ).start();
        //使用Lambda表达式
        new Thread(
                () ->
                {
                    System.out.println(Thread.currentThread().getName() + "创建了一个新的线程2");
                }
        ).start();

        //使用Lambda表达式的省略版本
        new Thread(
                ()-> System.out.println(Thread.currentThread().getName() + "创建了一个新的线程2")
        ).start();

    }
}
