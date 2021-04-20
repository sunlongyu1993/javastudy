package com.testfan.javastudy.Day0420.Demo01;

import org.apache.xpath.operations.String;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输入流：一次读取多个字符
 */
public class Demo02ReaderStudy {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo01\\1.txt");
        char[] chars = new char[1024];
        int len =0;
        while ((len =fr.read(chars))!=-1){
//            System.out.print(new String(chars,0,len));
        }
        fr.close();
    }
}