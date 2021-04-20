package com.testfan.javastudy.Day0417.Demo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 孙珑瑜
 * @version 20210419
 * 字节输出流的续写和换行
 */
public class OutputStreamDemo03 {
    public static void main(String[] args) throws IOException {
        // true :追加开关
        FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0417\\Demo01\\1.txt", true);
        fos.write("你好周一".getBytes());
        for (int i = 1; i < 10; i++) {
            fos.write("不开心".getBytes());
            fos.write("\r\n".getBytes());//换行
        }
        fos.close();
    }
}
