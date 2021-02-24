package com.testfan.javastudy.day0220.ExtendStudy.Five;

/**
 * @author 孙珑瑜
 * @version 20210224
 */
public class PhoneZi extends Phone{
    @Override
    public void call(){
        System.out.println("打电话");
    }
    @Override
    public void send(){
        System.out.println("发短信");
    }
    @Override
    public void show(){
//        System.out.println("显示号码");
        super.show();
        System.out.println("显示头像");
        System.out.println("显示姓名");

    }
}
