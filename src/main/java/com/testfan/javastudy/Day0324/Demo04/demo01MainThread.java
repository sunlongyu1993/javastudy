package com.testfan.javastudy.Day0324.Demo04;

public class demo01MainThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("sly1");
        myThread.start();

        new MyThread("1111").start();
    }
}
