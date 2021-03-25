package com.testfan.javastudy.Day0324.Demo03;

public class MyThread extends Thread{
    @Override
    public void run() {
//        String name = getName();//获取线程名称
//        System.out.println(name);
//        Thread t = Thread.currentThread();
//        String name = t.getName();
//        System.out.println(name);
//      链式编程
        System.out.println(Thread.currentThread().getName());
    }
}
