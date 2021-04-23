package com.testfan.javastudy.Day0422.Demo03;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 字符缓冲输出流
 */
public class Demo01BufferedWriter {
    public static void main(String[] args) throws IOException {
        //第一步：创建一个字符输出流对象FileWriter，构造方法中绑定要写入的目的地
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.txt");
        //第二步：创建字符缓冲输出流对象BufferedWriter，构造方法中传递字节输出流
        BufferedWriter br = new BufferedWriter(fw);
        //第三步：使用字符缓冲输出流对象中的Writer方法，写数据到内存缓冲区中
        for (int i = 0; i < 10; i++) {
            br.write("sly，你最棒，加油"+i);
            br.newLine();
        }

        br.flush();
        br.close();

    }
}
