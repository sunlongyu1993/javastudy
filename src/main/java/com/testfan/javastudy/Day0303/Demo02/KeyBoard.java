package com.testfan.javastudy.Day0303.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
//键盘就是一个usb设备
public class KeyBoard implements USB {
    @Override
    public void open() {

        System.out.println("打开键盘");
    }

    @Override
    public void off() {

        System.out.println("关闭键盘");
    }

    public void type() {
        System.out.println("键盘特有方法，键盘输入");
    }
}
