package com.testfan.javastudy.Day0420.Demo02;

import java.io.FileWriter;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 * 写数据的其他方法
 */
public class Demo03WriterStudy {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo02BufferedReader\\1.txt");
        char[] cs = {'a','b','c','d','e'};
//        fw.write(cs);
//        fw.write(cs,1,3);
//        fw.write("11122233dfasdfas");
        fw.write("孙珑瑜，你最棒",4,3);
        fw.close();
    }
}
