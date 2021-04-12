package com.testfan.javastudy.Day0412.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210412
 */
public class Baozipu extends Thread{
    private Baozi baozi;//需要在成员位置创建一个包子变量
    public Baozipu() {}
    public Baozipu(Baozi baozi) {//使用带参数的构造方法，为包子变量赋值
        this.baozi = baozi; }
    @Override//设置线程任务，生产包子
    public void run() {
        int count= 0;        //定义一个变量
        while (true){//让包子铺一直生产包子
        synchronized (baozi){//必须使用同步技术，保证2个线程只有1个在执行
            if (baozi.flag){//对包子的状态进行判断
                try {
                    baozi.wait();//包子铺调用wait方法进入等待状态
                } catch (InterruptedException e) {
                    e.printStackTrace(); } }
            //被唤醒之后执行，包子铺生成包子
            //交替生产2种包子
            if(count %2 ==0){
                System.out.println("生成薄皮三鲜包子");
                baozi.pi = "薄皮";
                baozi.xian = "三鲜"; }
            else {
                System.out.println("生成冰皮牛肉包子");
                baozi.pi = "冰皮";
                baozi.xian = "牛肉"; }
            count ++;
            System.out.println("包子铺正在生产"+baozi.pi+baozi.xian+"的包子");
            try {//生产包子需要3S
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace(); }
            //包子铺生产好包子了，可以修改包子的状态为有包子
            baozi.flag =true;
            //唤醒吃货线程，让吃货线程吃包子
            baozi.notify();
            System.out.println("包子铺已经生成好包子："+baozi.pi+baozi.xian+"的包子了");
        }
    }
    }
}
