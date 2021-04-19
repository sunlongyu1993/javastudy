package com.testfan.javastudy.Day0419.Demo02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 练习-文件复制：一次读取一个字节，写入一个字节
 */
public class Demo01Test {
    public static void main(String[] args) throws IOException {
        long s= System.currentTimeMillis();

        //第一步：创建一个字节输入流对象FileInputStream，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo01\\1.jpg");//需要读取的数据源
        //创建一个字节输出流对象FileOutputStream，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo02\\1.jpg");//需要写入的目的地

        //第二步：一次读取一个字节，写入一个字节
        //使用字节输入流对象中的方法 read读取文件
        int len =0;
        while ((len=fis.read())!=-1){
            //使用字节输出流的write把读取的字节写入到目的地的文件中
            fos.write(len);
        }
        //第三步：释放资源（先关闭写的，再关闭读的）
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时："+(e-s)+"毫秒");
    }
}
