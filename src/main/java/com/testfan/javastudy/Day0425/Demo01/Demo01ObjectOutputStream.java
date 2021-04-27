package com.testfan.javastudy.Day0425.Demo01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 孙珑瑜
 * @version 20210425
 * 序列化
 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\Person.txt"));
        oos.writeObject(new Person("sly",18));
        oos.close();
    }

}
