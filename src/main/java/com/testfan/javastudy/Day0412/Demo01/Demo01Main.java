package com.testfan.javastudy.Day0412.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210412
 */
public class Demo01Main {
    public static void main(String[] args) {
     Baozi baozi = new Baozi();
     new Baozipu(baozi).start();
     new Chihuo(baozi).run();
    }
}
