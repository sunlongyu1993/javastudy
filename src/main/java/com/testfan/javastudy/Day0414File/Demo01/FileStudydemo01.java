package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 静态成员变量
 */
public class FileStudydemo01 {
    public static void main(String[] args) {
        String s = File.pathSeparator;//路径分隔符 ;
        System.out.println(s);
        String v =File.separator;//文件名称分隔符 \
        System.out.println(v);
        String path = "C:"+File.separator+"a.txt";
    }
}
