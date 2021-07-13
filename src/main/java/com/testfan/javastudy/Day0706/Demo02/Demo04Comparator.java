package com.testfan.javastudy.Day0706.Demo02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 孙珑瑜
 * @version 210713
 * Lambda 作为方法参数
 */
public class Demo04Comparator {
    public static Comparator<String> getComparator(){
//        定义一个返回值类型是一个接口，可以返回这个接口的匿名内部类
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        };
        //定义一个返回值类型是一个接口，可以返回这个接口用Lambda表达式
//        return (String o1, String o2)->{
//            return o2.length()-o1.length();
//        };

        //定义一个返回值类型是一个接口，可以返回这个接口用Lambda表达式
        return ( o1,  o2)-> o2.length()-o1.length();
    }

    public static void main(String[] args) {
        String[] arr ={"aaa","b","ccccccc"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));

    }
}
