package com.testfan.javastudy.Day0303.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
//鼠标就是一个usb设备
public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void off() {
        System.out.println("关闭鼠标");
    }
    public void click(){
        System.out.println("鼠标点击");
    }

}
