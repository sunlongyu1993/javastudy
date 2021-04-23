package com.testfan.javastudy.Day0416.Demo03;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author 孙珑瑜
 * @version 20210416
 * FilenameFilter 过滤器——使用匿名内部类
 */
public class Demo03FileFilter {
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
        //FilenameFilter 使用匿名内部类
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //File(dir,name):父路径是目录，子目录是文件
                //name:是每个文件名称，和目录组成一个文件对象
                return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
            }
        });
        //使用lambda表达式优化(接口中只有一个抽象方法)
        File[] files1 = dir.listFiles((File dir1, String name1)->{
            return new File(dir,name1).isDirectory()||name1.toLowerCase().endsWith(".java");
                });
        //对lambda表达式优化
        File[] files2 = dir.listFiles((dir2,name2)->new File(dir,name2).isDirectory()||name2.toLowerCase().endsWith(".java"));
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
