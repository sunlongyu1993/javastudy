package com.testfan.javastudy.Day0414File.Demo01;


import java.io.File;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210414
 * 目录的遍历
 */
public class FileStudydemo06 {
    public static void main(String[] args) {
//        show01();
        show02();


    }
    private static void show01(){
//        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy");
//        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\workoutstudy.java");
        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\workouty.java");
        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
    private static void show02(){
        File file1 = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0414File");
        File[] files = file1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

    }
}
