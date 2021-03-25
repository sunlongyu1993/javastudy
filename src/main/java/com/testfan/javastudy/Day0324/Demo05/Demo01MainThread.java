package com.testfan.javastudy.Day0324.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210325
 */
public class Demo01MainThread {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t = new Thread(runnable);
        t.start();//新线程

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
