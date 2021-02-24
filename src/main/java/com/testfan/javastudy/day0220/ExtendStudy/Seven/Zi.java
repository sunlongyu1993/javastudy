package com.testfan.javastudy.day0220.ExtendStudy.Seven;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class Zi extends Fu {
    int num =20;

    public Zi() {
        super();//3、在子类的构造方法中，访问父类的构造方法
    }

    public void methodZi(){
        System.out.println(super.num);//1、在子类的成员方法中，访问父类的变量
        System.out.println(this.num);
        super.methodFu();//2、在子类的成员方法中，访问父类的成员方法
    }


}
