package com.testfan.javastudy.Day0328.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210326
 * 同步方法1：同步代码块
 */
public class RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    Object obj = new Object();//创建一个锁对象

    @Override//设置线程任务：卖票
    public void run() {
       while (true){
           synchronized (obj){
               //先判断票是否存在
               if(ticket>0){
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   //票存在，开始卖票
                   System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket);
                   ticket--;
               }
           }
       }
    }
}
