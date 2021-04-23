package com.testfan.javastudy.Day0420.Demo01;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输入流：一次读取一个字符
 */
public class Demo01ReaderStudy {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo01BufferedWriter\\1.txt");
        int len =0;
        while ((len =fr.read())!=-1){
            System.out.print((char)len);
        }
        fr.close();
    }
}