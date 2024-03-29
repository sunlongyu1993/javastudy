package com.testfan.javastudy.Day0416.Demo03;

import java.io.File;

/**
 * @author 孙珑瑜
 * @version 20210416
 * FileFilter 过滤器
 */
public class Demo01FileFilter {
    public static void main(String[] args) {
        File file = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0416\\Demo02BufferedReader");
        //File.separator 根据系统来判断拼接符
        File file2 = new File("D:"+File.separator+"code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0416\\Demo02BufferedReader");
        getAllFile(file);
    }

    /**
     * 定义一个方法，参数传递file类型的目录
     * 方法中对目录进行遍历
     * @param dir
     */
    private static void getAllFile(File dir) {
//        System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles(new FileFilterImpl());//遍历目录
        for (File file : files) {//对遍历得到的file 对象file进行判断
            // 判断是否是目录
            if (file.isDirectory()){
                getAllFile(file);//file 如果是一个目录，则继续遍历这个目录
            }
            else {
                System.out.println(file);//file是一个文件直接打印即可

            }
        }
    }
}
