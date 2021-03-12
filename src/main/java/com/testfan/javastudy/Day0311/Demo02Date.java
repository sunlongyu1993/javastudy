package com.testfan.javastudy.Day0311;

import java.util.Date;

/**
 * @author 孙珑瑜
 * @version 20210311
 */
public class Demo02Date {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    public static void  demo01(){
        Date date = new Date();
        System.out.println(date);
    }
    public static void  demo02(){//有参构造
        Date date = new Date(0L);
        System.out.println(date);
    }
    public static void  demo03(){//有参构造
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
