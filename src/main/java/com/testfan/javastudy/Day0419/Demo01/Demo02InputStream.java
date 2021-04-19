package com.testfan.javastudy.Day0419.Demo02;

import org.apache.xpath.operations.String;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 孙珑瑜
 * @version 20210419
 */
public class Demo01InputStream {
//    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo01\\1.txt");
//        //使用FileInputStream对象中的方法read读取文件
//        // int read(byte[] b)从输入流中读取一定量的字节，将其存储到缓冲区数组b 中
////        byte[] b = new byte[3];
////
////        int read = fis.read(b);
////        System.out.println(read);//每次读取字节的个数
//////        System.out.println(Arrays.toString(b));//遍历数组
//////        System.out.println(new String(b));
////
////
////        int read1 = fis.read(b);
////        System.out.println(read1);
//////        System.out.println(new String(b));
//        byte[] bytes = new byte[1024];//存储读取到的多个字节
//        int len = 0;//记录每次读取到的字节个数
//        while ((len = fis.read(bytes))!=-1){
//            System.out.println(bytes);
//        }
//
//
//        fis.close();//释放资源
//    }
public static void main(String[] args) throws IOException {
            FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo01\\1.txt");
            byte[] bytes = new byte[1024];//存储读取到的多个字节
            int len = 0;//记录每次读取到的字节个数
            while ((len = fis.read(bytes))!=-1){
//                System.out.println(new String(bytes));
            }
}

}
