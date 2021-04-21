package com.testfan.javastudy.Day0421.Demo01;

import java.util.Properties;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20210421
 * Properties 集合存储以及遍历数据
 */
public class Demo01Properties {
    public static void main(String[] args) {
        Properties pros = new Properties();
        pros.setProperty("sly1","18");
        pros.setProperty("sly2","19");
        pros.setProperty("sly3","20");
        pros.setProperty("sly4","21");

        Set<String> prosets = pros.stringPropertyNames();
        for (String prokey : prosets) {
            String proValue = pros.getProperty(prokey);
            System.out.println(prokey+"="+proValue);
        }
    }
}
