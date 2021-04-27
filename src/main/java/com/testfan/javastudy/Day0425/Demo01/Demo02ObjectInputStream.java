package com.testfan.javastudy.Day0425.Demo01;

import java.io.*;

/**
 * @author 孙珑瑜
 * @version 20210425
 * 反序列化
 */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\Person.txt"));
//        Object obj = ois.readObject();
//        System.out.println(obj);

        Person per  = (Person) ois.readObject();
        System.out.println(per.getName()+per.getAge());
        ois.close();
    }

}
