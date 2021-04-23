package com.testfan.javastudy.Day0420.Demo03;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 * IO处理异常：try catch
 */
public class Demo01WriterIO {
    public static void main(String[] args) {
        FileWriter fw=null;
        try {
            fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo02BufferedReader\\1.txt", true);
            for (int i = 1; i <10 ; i++) {
                fw.write("helloWorld!"+i+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
