package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 常用方法-判断
 */
public class FileStudydemo04 {
    public static void main(String[] args) {
//        show01();
        show02();

    }
    private static void show01(){
        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        File file2 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例");
        File file3 = new File("V2.0测试用例");
        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println(file3.exists());
    }

    private static void show02(){
        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        File file3 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例");
        if(file1.exists() && file3.exists()){
            System.out.println(file1.isDirectory());
            System.out.println(file1.isFile());

            System.out.println(file3.isDirectory());
            System.out.println(file3.isFile());
        }


    }
}
