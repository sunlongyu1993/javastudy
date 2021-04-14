package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 构造方法
 */
public class FileStudydemo02 {
    public static void main(String[] args) {
//        show01();
//        show02("C:\\","a.txt");
        show03();
    }
//    private static void show01(){
//        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\a.txt");
//        File file2 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例");
//        System.out.println(file1);
//        System.out.println(file2);
//        File file3 = new File("b.txt");
//        System.out.println(file3);
//    }
//    private static void show02(String parent,String child){
//        File file = new File(parent,child);
//        System.out.println(file);
//    }

    private static void show03(){
        File parent = new File("c:\\");
        File file = new File(parent,"hello.txt");
        System.out.println(file);
    }
}
