package com.testfan.javastudy.Day0420.Demo03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 * IO处理异常：JDK7新特性：
 * try (定义流对象){
 *可能会产生异常的代码
 * }
 * catch(异常类变量 变量名){
 *异常的处理逻辑
 * }
 */
public class Demo02WriterJDK7 {
    public static void main(String[] args) {
        try(    //第一步：创建一个字节输入流对象FileInputStream，构造方法中绑定要读取的数据源
                FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo01BufferedWriter\\1.jpg");//需要读取的数据源
                //创建一个字节输出流对象FileOutputStream，构造方法中绑定要写入的目的地
                FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo03\\1.jpg");//需要写入的目的地
                )
        {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


