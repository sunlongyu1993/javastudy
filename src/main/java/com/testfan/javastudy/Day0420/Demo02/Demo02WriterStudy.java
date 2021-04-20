package com.testfan.javastudy.Day0420.Demo02;

import java.io.FileWriter;

/**
 * @author 孙珑瑜
 * @version 20210420
 * 字符输出流：write
 * flush方法和close方法的区别
 */
public class Demo02WriterStudy {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo02\\1.txt");
        fw.write(97);
        fw.flush();
        //flush刷新后可以继续使用
        fw.write(98);
        fw.close();
//        fw.write(99);//close后流就消失了，不能再写入了

    }
}
