package com.testfan.javastudy.Day0706.Demo02;

/**
 * @author 孙珑瑜
 * @version 210713
 * Lambda 作为方法参数
 */
public class Demo03Lambdaparm {
    public static void showLambda(Runnable run){
        new Thread(run).start();//开启多线程

    }
    public static void main(String[] args) {
        showLambda(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动1");
            }
        });
        showLambda(()->{
            System.out.println(Thread.currentThread().getName()+"线程启动2");;});
        showLambda(()-> System.out.println(Thread.currentThread().getName()+"线程启动3"));
    }
}
