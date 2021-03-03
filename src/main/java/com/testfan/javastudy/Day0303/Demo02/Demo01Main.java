package com.testfan.javastudy.Day0303.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Demo01Main {
    public static void main(String[] args) {
        //创建一个笔记本电脑
        Laptop laptop = new Laptop();
        laptop.poweOn();

        //准备一个鼠标，供电脑使用
        Mouse mouse = new Mouse();
        //首先向上转型
        //USB usb = mouse;
        USB usb = new Mouse();//左父右子，左接口右实现类，多态
        laptop.useDevice(usb);//参数是USB类型，传递进去的参数是USB鼠标

        //创建一个USB键盘
        KeyBoard keyBoard = new KeyBoard();//没有使用多态写法
        //方法参数是USB类型，传递进入的是实现类对象
        laptop.useDevice(keyBoard);//正确写法，可传入参数，发生了向上转型

        //使用子类对象，匿名对象，也可以
//        laptop.useDevice(new KeyBoard());//也是正确写法，可传入参数，发生了向上转型

        laptop.poweOff();
    }
}
