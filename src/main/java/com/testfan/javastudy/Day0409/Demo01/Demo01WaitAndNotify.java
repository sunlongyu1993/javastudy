package com.testfan.javastudy.Day0409.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210409
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();//创建锁对象，保证唯一
        new Thread(){
            @Override//创建一个顾客线程
            public void run() {
                synchronized (obj){//保证等待和唤醒的线程只有一个执行，需要使用同步技术


                }
            }
        };

    }
}
