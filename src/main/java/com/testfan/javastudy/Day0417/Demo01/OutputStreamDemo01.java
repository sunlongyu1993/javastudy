package com.testfan.javastudy.Day0417.Demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210417
 * 字节输出流写入数据到文件
 */
public class OutputStreamDemo01 {
    public static void main(String[] args)  {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0416\\Demo02\\1.txt");
            fos.write(97);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
