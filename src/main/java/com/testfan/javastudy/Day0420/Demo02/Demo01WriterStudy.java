package com.testfan.javastudy.Day0420.Demo02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 */
public class Demo01WriterStudy {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo02BufferedReader\\1.txt");
        fw.write(97);
        fw.flush();
        fw.close();

    }
}
