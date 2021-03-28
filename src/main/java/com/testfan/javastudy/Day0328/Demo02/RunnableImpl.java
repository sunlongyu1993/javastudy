package com.testfan.javastudy.Day0328.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210326
 * 同步方法2：同步方法
 */
public class RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    @Override//设置线程任务：卖票
    public void run() {
       while (true){//使用死循环，让买票操作重复进行
           payTicket();
       }
    }
//定义一个同步方法
    public synchronized void payTicket(){
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
