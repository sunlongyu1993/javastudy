package com.testfan.javastudy.Day0422.Demo01;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210421
 * 缓冲流：字节缓冲输入流
 */
public class Demo02BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        //创建FileInputStream 对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.txt");
        //创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的读取效率
        BufferedInputStream bis = new BufferedInputStream(fis);
        //使用BufferedInputStream对象中的read方法，读取文件
        //一次读取1个字节
//        int len =0;//记录每次读取到的字节
//        while ((len =bis.read())!=-1){
//            System.out.println(len);
//        }
        //一次读取多个字节
        byte[] bytes = new byte[1024];//存储每次读取的数据
        int len =0;//记录每次读取的有效字符个数
        while ((len = bis.read(bytes))!=-1){
            System.out.println(len);
        }
        bis.close();

    }
}
