package com.testfan.javastudy.Day0412.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210412
 * 2、创建一个类，实现Runnable接口，重写run方法，设置线程任务
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程");
    }
}
