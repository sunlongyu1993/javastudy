package com.testfan.javastudy.Day0416.Demo03;
import java.io.File;
import java.io.FileFilter;
/**
 * @author 孙珑瑜
 * @version 20210416
 * FileFilter 过滤器——使用匿名内部类
 */
public class Demo02FileFilter {
    public static void main(String[] args) {
        File file = new File("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0416\\Demo02BufferedReader");
        getAllFile(file);
    }
    /**
     * 定义一个方法，参数传递file类型的目录
     * 方法中对目录进行遍历
     * @param dir
     */
    private static void getAllFile(File dir) {
        //使用匿名内部类
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //过滤规则，pathname是文件夹或是.java结尾的文件返回true
                return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");
            }
        });
        //使用Lambda表达式
        File[] files1 = dir.listFiles(
                (File pathname)->{return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");}
        );
        //使用Lambda表达式的简化版
        File[] files2 = dir.listFiles(pathname->pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java"));
        //遍历目录
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
