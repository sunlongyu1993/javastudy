package com.testfan.javastudy.Day0317.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210318
 * 可变参数
 */
public class Demo04Main {
    public static void main(String[] args) {
//        addkey();
        int addkey = addkey(1, 2, 3);
        System.out.println(addkey);

    }

    public static  int addkey(int...arr){
        int sum =0;
        for (int i : arr) {
            sum +=i;
        }
        return sum;
//        System.out.println(arr);
//        System.out.println(arr.length);
    }
    //    public static int add(int a,int b){
//        return a+b;
//    }
}
