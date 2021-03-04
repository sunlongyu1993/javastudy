package com.testfan.javastudy.Day0304.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210304
 */
public class Demo01Main {
    public static void main(String[] args) {
//        Body body =new Body();//外部类的对象
//        //通过外部类的对象，调用外部类的方法，里边间接使用内部类Heat
//        body.methodBody();
//
//        System.out.println("========================");
//        Body.Heart heart = new Body().new Heart();
//        heart.beat();

        System.out.println("========================");
        Outer.Inner inner = new Outer().new Inner();
        inner.methodInner();
    }
}
