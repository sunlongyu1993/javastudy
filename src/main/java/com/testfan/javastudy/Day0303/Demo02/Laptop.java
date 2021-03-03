package com.testfan.javastudy.Day0303.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Laptop {
    public void poweOn(){
        System.out.println("笔记本具有开机功能");
    }
    public void poweOff(){
        System.out.println("笔记本具有关机功能");
    }
    //使用USB设备的方法，使用接口作为方法的参数
    public void useDevice(USB usb){
        usb.open();//打开设备

        //向下转型
        if (usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }
        else if (usb instanceof KeyBoard){
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.type();
        }

        usb.off();// 关闭设备
    }

}
