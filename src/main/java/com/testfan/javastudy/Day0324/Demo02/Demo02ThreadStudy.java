package com.testfan.javastudy.Day0324.Demo02;

/**
 * 多线程
 */
public class Demo02ThreadStudy {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main"+i);
        }
    }
}
