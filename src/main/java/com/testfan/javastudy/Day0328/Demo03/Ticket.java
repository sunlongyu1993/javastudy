package com.testfan.javastudy.Day0328.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210326
 * 模拟卖票的案例
 * 创建3个线程，同时开启，对共享的票进行出售
 *
 */
public class Ticket {
    public static void main(String[] args) {
        //创建Runable 接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();
//        创建Thread类对象，构造方法中传递Runable接口的实现类对象
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}
