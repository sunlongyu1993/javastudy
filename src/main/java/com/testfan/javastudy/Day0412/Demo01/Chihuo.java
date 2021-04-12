package com.testfan.javastudy.Day0412.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210412
 * 吃货对象
 */
public class Chihuo extends Thread {
    private Baozi baozi;//需要在成员位置创建一个包子变量
    public Chihuo() {
    }
    public Chihuo(Baozi baozi) {//使用带参数的构造方法，为包子变量赋值
        this.baozi = baozi;
    }

    @Override//设置线程任务，吃包子
    public void run() {
        while (true){//使用死循环，让吃货一直吃包子
            synchronized (baozi){//必须使用同步技术，保证2个线程只有1个在执行
                if (baozi.flag == false){
                    //吃货调用wait进入Waiting状态
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //被唤醒之后执行的代码：吃包子
                    System.out.println("吃货正在吃"+baozi.pi+baozi.xian+"的包子");
                    baozi.flag = false;//吃货吃完包子，修改包子的状态为false
                    baozi.notify();//唤醒包子铺线程，生产包子
                    System.out.println("吃货已经吃完包子，包子铺开始生产："+baozi.pi+baozi.xian+"的包子");
                    System.out.println("=================================================");
                }
            }
        }
    }
}
