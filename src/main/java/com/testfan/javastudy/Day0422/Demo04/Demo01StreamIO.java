package com.testfan.javastudy.Day0422.Demo04;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210423
 * 转换流
 *
 */
public class Demo01StreamIO {
    public static void main(String[] args) throws IOException {
        String path = "D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path+"\\GBKtest.txt"),"gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path+"\\utf8test.txt"),"utf-8");
//        osw.write("你好");
        int len =0;
        while ((len= isr.read())!=-1){
            osw.write(len);
        }
        osw.flush();
        osw.close();
        isr.close();
    }
}
