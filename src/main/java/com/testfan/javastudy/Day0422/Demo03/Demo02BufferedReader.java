package com.testfan.javastudy.Day0422.Demo03;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 字符缓冲输入流
 */
public class Demo02BufferedReader {
    public static void main(String[] args) throws IOException {
        //第一步：创建一个字符输入流FileReader，构造方法中绑定要读取的目标文件
        FileReader fr = new FileReader("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.txt");
        //第二步：创建字符缓冲输入流对象BufferedReader，构造方法中传递字节输入流
        BufferedReader br = new BufferedReader(fr);
        //第三步：使用字符缓冲输入流对象中的Reader方法，读取文本
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
