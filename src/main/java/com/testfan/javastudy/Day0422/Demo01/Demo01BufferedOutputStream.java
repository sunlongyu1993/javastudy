package com.testfan.javastudy.Day0422.Demo01;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210421
 * 缓冲流：字节缓冲输出流
 */
public class Demo01BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        //创建FileOutputStream 对象，构造方法中绑定要输出的目的地
        FileOutputStream fos = new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\1.txt");
        //创建BufferedOutputStream对象，构造方法中传递FileOutputStream 对象，提供FileOutputStream对象的效率
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //使用BufferedOutputStream对象中的write方法，把数据写入到内部缓冲区
        bos.write("我把内容写到内部缓冲区".getBytes());
        //使用BufferedOutputStream对象中的flush方法，把内部缓冲区中的数据刷新到文件中
        bos.flush();
        bos.close();//释放资源
    }
}
