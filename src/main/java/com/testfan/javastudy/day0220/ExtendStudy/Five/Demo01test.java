package com.testfan.javastudy.day0220.ExtendStudy.Five;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class Demo01test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("=============================");
        PhoneZi phoneZi = new PhoneZi();
        phoneZi.call();
        phoneZi.send();
        phoneZi.show();
    }
}
