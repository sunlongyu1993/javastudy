package com.testfan.javastudy.Day0409.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210409
 *
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();//创建锁对象，保证唯一

        new Thread(){
            @Override//创建一个顾客线程
            public void run() {
                synchronized (obj){//保证等待和唤醒的线程只有一个执行，需要使用同步技术
                    System.out.println("告知老板要的包子的种类和数量");
                    //wait 方法，放弃CPU的执行，进入到WAITING状态（无限等待状态）
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒只有执行的代码
                    System.out.println("包子已经做好了，开吃");

                }
            }
        }.start();
        new Thread(){//一个老板的线程（生产者）
            @Override
            public void run() {
                //花5秒钟做包子，就需要睡眠5秒钟
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    //做好包子之后，调用notify方法，唤醒顾客吃包子
                    System.out.println("老板线程，唤醒顾客吃包子");
                    obj.notify();
                }
            }
        }.start();

    }
}
