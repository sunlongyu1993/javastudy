package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 构造方法
 */
public class FileStudydemo03 {
    public static void main(String[] args) {
//        show01();
//        show02();
//        show03();
        show04();
    }
    private static void show01(){
        File file = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        String absolutePath1 = file.getAbsolutePath();
        System.out.println(absolutePath1);

        File file2 = new File("a.txt");
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2);
    }

    private static void show02(){
        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        File file2 = new File("a.txt");
        System.out.println(file1.getPath());
        System.out.println(file2.getPath());

    }

    private static void show03(){
        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        System.out.println(file1.getName());

        File file2 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例");
        System.out.println(file2.getName());
    }

    private static void show04(){
        File file1 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例\\a.txt");
        System.out.println(file1.length());

        File file2 = new File("C:\\Users\\sunlongyu\\Desktop\\V2.0测试用例");
        System.out.println(file2.length());

    }
}
