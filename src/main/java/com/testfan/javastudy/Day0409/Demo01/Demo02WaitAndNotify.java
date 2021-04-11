package com.testfan.javastudy.Day0409.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210411
 */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(){
            @Override
            public void run() {
                //一直等待买包子
                //等待保证和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (object){
                    System.out.println("顾客1告知老板要的包子的种类和数量");
                    //wait 方法，放弃CPU的执行，进入到WAITING状态（无限等待状态）
                    try {
                        object.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//唤醒只有执行的代码
                    System.out.println("包子已经做好了，顾客1开吃");
                    System.out.println("===================================");
                }
            }
        }.start();
        new Thread(){//顾客2开吃
            @Override
            public void run() {
                //一直等待买包子
                //等待保证和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (object){
                    System.out.println("顾客2告知老板要的包子的种类和数量");
                    //wait 方法，放弃CPU的执行，进入到WAITING状态（无限等待状态）
                    try {
                        object.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//唤醒只有执行的代码
                    System.out.println("包子已经做好了，顾客2开吃");
                    System.out.println("===================================");
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
                synchronized (object){
                    //做好包子之后，调用notify方法，唤醒顾客吃包子
                    System.out.println("老板线程，唤醒顾客吃包子");
                    object.notifyAll();
//                    object.notify();
                }
            }
        }.start();
    }

}
