package com.testfan.javastudy.Day0324.Demo03;

public class demo01MainThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        new MyThread().start();
        new MyThread().start();
        System.out.println(Thread.currentThread().getName());
    }
}
