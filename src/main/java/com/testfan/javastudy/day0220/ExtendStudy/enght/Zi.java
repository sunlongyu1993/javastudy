package com.testfan.javastudy.day0220.ExtendStudy.enght;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class Zi extends Fu {
    int num =20;

    public Zi() {
        this(10);//本类的无参构造调用本类的有参数构造
    }
    public Zi(int n) {
    }
    public Zi(int n,int m) {
    }

    public void showNum(){
        int num = 10;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
    public void MethodA(){
        System.out.println("AAAAA");

    }
    public void MethodB(){
        System.out.println("BBBBs");

        this.MethodA();
    }
}
