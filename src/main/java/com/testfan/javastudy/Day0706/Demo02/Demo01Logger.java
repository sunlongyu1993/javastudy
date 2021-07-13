package com.testfan.javastudy.Day0706.Demo02;

/**
 * @author 孙珑瑜
 * @version 210707
 */
public class Demo01Logger {
    public static void showlogo(int level,String message){
        if(level ==1){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        String msg1= "hello";
        String msg2= "world";
        String msg3= "java";
        showlogo(1,msg1+msg2+msg3);
    }
}
