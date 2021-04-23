package com.testfan.javastudy.Day0422.Demo02;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 练习-文件复制：使用字节缓冲流
 * 一次读取一个字节，写入一个字节
 * 
 */
public class Demo03Test {
    public static void main(String[] args) throws IOException {
        long s= System.currentTimeMillis();
        //第一步：创建一个字节输入流对象FileInputStream，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.jpg");//需要读取的数据源
        //创建一个字节输出流对象FileOutputStream，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0422\\Demo02BufferedReader\\1.jpg");//需要写入的目的地
        //第二步：创建字节缓冲输入流对象，构造方法中传递字节输入流
        BufferedInputStream bis = new BufferedInputStream(fis);
        //创建字节缓冲输出流对象，构造方法中传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //第三步：使用字节缓冲输入流对象中的read方法，读取文件
        //一次读取一个字节，写入一个字节
        int len =0;
        while ((len =bis.read())!=-1){
            //使用字节缓冲输出的write,把读取的字节写入到目的地的文件中
            bos.write(len);
        }
//        //第四步：释放资源（先关闭写的，再关闭读的）
        bis.close();
        bos.close();
        long e= System.currentTimeMillis();
        System.out.println("复制文件共耗时："+(e-s)+"毫秒");

    }
}
