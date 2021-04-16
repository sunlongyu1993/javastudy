package com.testfan.javastudy.Day0416.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 递归 -练习1: 递归求和
 */
public class DiguiStudy02 {
    public static void main(String[] args) {
        int sums = sum(5);
        System.out.println(sums);
    }
    //使用递归
    private static int sum(int n) {
        if (n ==1){//获取到1的时候结束
            return 1;
        }
        //获取下一个倍加的数字（n-1）
        return n+sum(n-1);
    }


}
