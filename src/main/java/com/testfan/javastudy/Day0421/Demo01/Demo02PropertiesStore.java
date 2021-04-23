package com.testfan.javastudy.Day0421.Demo01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210421
 * Properties集合中的方法Store
 */
public class Demo02PropertiesStore {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        pros.setProperty("sly1","18");
        pros.setProperty("sly2","19");
        pros.setProperty("sly3","20");
        pros.setProperty("sly4","21");
        FileWriter fw = new FileWriter("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\Day0420\\Demo01BufferedWriter\\1.txt");
        pros.store(fw,"save data");
        fw.close();

    }
}
