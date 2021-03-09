package com.testfan.javastudy.Day0306.Demo01;

import com.testfan.javastudy.Day0306.Red.OpenMode;

/**
 * @author 孙珑瑜
 * @version 20210306
 * 发红包案例分析
 * Bootstrap：启动
 */
public class Bootstrap {
    public static void main(String[] args) {
        //参数就是标题
        MyRed myRed = new MyRed("sly的java红包");
        myRed.setOwnerName("sly");

        OpenMode normal = new NormalMode();
        myRed.setOpenWay(normal);
    }
}
