package com.testfan.javastudy.Day0412.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210412
 */
public class DemoMain {
    public static void main(String[] args) {

        Runnable r = new RunnableImpl();//创建Runnable接口的实现类对象
        Thread t  = new Thread(r);//创建Thread类对象，购造方法中传递Runnable接口的实现类
        t.start();//调用start方法开启新线程，执行run方法

    //简化代码,使用匿名内部类，实现多线程程序
        Runnable r2 = new Runnable(){
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+"创建了一个新的线程2");
            }
        };
        new Thread(r2).start();

        //继续简化
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程3");
                    }
                }
        ).start();
    }
}
