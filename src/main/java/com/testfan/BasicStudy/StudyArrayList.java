package com.testfan.BasicStudy;

import java.util.ArrayList;

/**
 * @author 孙珑瑜
 * @version 20200930
 */
public class StudyArrayList {
    public static void main(String[] args) {

        //集合
        ArrayList<String> stus = new ArrayList<String>();

        stus.add("张三");
        stus.add("李四");
        stus.add("王五");
        stus.add("赵六");
        stus.add("钱七");

        System.out.println("集合大小是："+stus.size());
//
//        stus.remove("钱七");
//        stus.remove(3);

//        System.out.println(stus.get(0));
//        System.out.println(stus.get(1));

//        for (int i = 0; i < stus.size(); i++) {
//            System.out.println(stus.get(i));
//        }
        // 用增强for循环来打印集合中的每一个元素
//        System.out.println("=========================");
//        for (String arr:stus) {
//            System.out.println(arr);
//        }

//        //插入元素
        stus.add(0,"张三三");
//        for (String arr:stus) {
//            System.out.println(arr);
//        }
//        System.out.println("=========================");
//        //修改
//        stus.set(0,"张三四");
//        for (String arr:stus) {
//            System.out.println(arr);
//        }
//
//
//        if(stus.contains("张三")){
//            System.out.println("包含");
//        }

//        ArrayList<Integer> iArray1 = new ArrayList<Integer>();
//        ArrayList<Double> iArray2 = new ArrayList<Double>();
//        ArrayList<Float> iArray3 = new ArrayList<Float>();
//        ArrayList<Byte> iArray4 = new ArrayList<Byte>();
//        ArrayList<Short> iArray5 = new ArrayList<Short>();
//        ArrayList<Long> iArray6 = new ArrayList<Long>();
        //
        int count = 0;
        for (String s:stus) {
            if(s.startsWith("张")){
                count++;
            }
        }
        System.out.println(count);

    }
}
