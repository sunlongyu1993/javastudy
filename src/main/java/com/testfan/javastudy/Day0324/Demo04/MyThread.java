package com.testfan.javastudy.Day0324.Demo04;

public class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);//把线程名称传递给父类，让父类给给子线程起一个名字
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
