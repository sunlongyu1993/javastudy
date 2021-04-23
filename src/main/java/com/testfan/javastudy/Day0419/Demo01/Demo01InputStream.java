package com.testfan.javastudy.Day0419.Demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 字节输入流读取字节数据
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0419\\Demo01BufferedWriter\\1.txt");
//        int len = fis.read();
//        int len1 = fis.read();
//        System.out.println(len);
//        System.out.println(len1);
        int len =0;
        while ((len =fis.read() )!= -1){
            System.out.println(len);
        }
        fis.close();

    }
}
