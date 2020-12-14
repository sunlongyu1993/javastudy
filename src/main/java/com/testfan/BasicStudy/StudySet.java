package com.testfan.BasicStudy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 孙珑瑜
 * @version 20200930
 */
public class StudySet {
    public static void main(String[] args) {
        Set<String> stus = new HashSet<String>();
        stus.add("张三");
        stus.add("张三");
        stus.add("张三");
        stus.add("李四");
        stus.add("王五");
        stus.add("赵六");
        stus.add("钱七");
        stus.remove("王五");

        System.out.println(stus.size());

        for (String s: stus) {
            System.out.println(s);
        }
    }
}
