package com.testfan.javastudy.Day0416.Demo01;

import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 递归 练习：综合案例
 */
public class DiguiStudy05 {
    public static void main(String[] args) {
        File file = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0416\\Demo02");
        getAllFile(file);
    }

    /**
     * 定义一个方法，参数传递file类型的目录
     * 方法中对目录进行遍历
     * @param dir
     */
    private static void getAllFile(File dir) {
//        System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();//遍历目录
        for (File file : files) {//对遍历得到的file 对象file进行判断，判断是否是目录
            if (file.isDirectory()){
                getAllFile(file);//file 如果是一个目录，则继续遍历这个目录
            }
            else {
                //file.getName()
                //file.getPath();

                if (file.toString().toLowerCase().endsWith(".java")){
                    System.out.println(file);//file是一个文件直接打印即可
                }
            }
        }
    }
}
