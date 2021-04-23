package com.testfan.javastudy.Day0420.Demo02;

import java.io.FileWriter;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 * 续写和换行
 */
public class Demo04WriterStudy {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo02BufferedReader\\1.txt", true);
        for (int i = 1; i <10 ; i++) {
            fw.write("helloWorld!"+i+"\r\n");
        }
        fw.close();
    }
}
