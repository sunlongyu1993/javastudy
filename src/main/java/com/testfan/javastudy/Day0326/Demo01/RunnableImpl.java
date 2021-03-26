package com.testfan.javastudy.Day0326.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210326
 */
public class RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    @Override//设置线程任务：卖票
    public void run() {
        for (int i = 0; i <ticket ; i++) {
            //先判断票是否存在
            if(ticket>0){//票存在，开始卖票
                System.out.println(Thread.currentThread().getName()+ticket);
                ticket--;
            }
            else {
                break;
            }
        }

    }
}
