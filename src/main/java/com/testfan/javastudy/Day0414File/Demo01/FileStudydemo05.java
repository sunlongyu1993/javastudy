package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 常用方法-创建和删除功能
 */
public class FileStudydemo05 {
    public static void main(String[] args) {
//        show01();
//        show02();
        show03();

    }
    private static void show01(){
        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0414File\\Demo01BufferedWriter\\b.txt");
        File file2 = new File("Day0414File\\Demo01BufferedWriter\\b1.txt");
        try {
            System.out.println(file1.createNewFile());
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void show02(){
        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0414File\\Demo03");
        File file2 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0414File\\Demo04\\Demo041");
        System.out.println(file1.mkdir());
        System.out.println(file2.mkdirs());
    }
    private static void show03(){
        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0414File\\Demo04\\Demo041");
        System.out.println(file1.delete());

    }
}
