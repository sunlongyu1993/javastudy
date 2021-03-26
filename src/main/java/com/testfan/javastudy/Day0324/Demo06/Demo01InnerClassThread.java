package com.testfan.javastudy.Day0324.Demo06;

import com.testfan.javastudy.Day0324.Demo05.RunnableImpl;

import java.util.Random;

/**
 * @author 孙珑瑜
 * @version 20210326
 * 匿名内部类
 */
public class Demo01InnerClassThread {
    public static void main(String[] args) {
//        new Thread(){//线程的父类是Thread
//            重写run方法，设置线程任务
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println(Thread.currentThread().getName()+i);//输出线程
//                }
//            }
//        }.start();
//  线程的接口Runnerable
//        RunnableImpl r = new RunnableImpl();

//        //Runnable r = new RunnableImpl();//多态
//        Runnable r =new Runnable(){//线程的接口Runnable
//            //            重写run方法，设置线程任务
//            @Override
//            public void run() {
//                for (int i = 0; i < 20; i++) {
//                    System.out.println(Thread.currentThread().getName()+"接口的实现类对象"+i);
//                }
//            }
//        };
//        new Thread(r).start();
        //简化接口的方法
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            System.out.println(Thread.currentThread().getName()+i);
                        }
                    }
                }
        ).start();
    }
}
