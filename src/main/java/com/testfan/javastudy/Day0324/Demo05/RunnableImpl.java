package com.testfan.javastudy.Day0324.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210325
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
