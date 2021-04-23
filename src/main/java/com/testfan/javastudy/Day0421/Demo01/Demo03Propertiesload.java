package com.testfan.javastudy.Day0421.Demo01;

import org.apache.groovy.json.internal.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210421
 * Properties集合中的方法load
 */
public class Demo03Propertiesload {
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileReader fr = new FileReader("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo01BufferedWriter\\1.txt");
        pros.load(fr);
        Set<String> sets = pros.stringPropertyNames();
        for (String key : sets) {
            String value = pros.getProperty(key);
            System.out.println(key+"=="+value);
        }
        fr.close();
    }
}
