package com.testfan.javastudy.Day0416.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210416
 * 递归-练习：递归阶乘
 */
public class DiguiStudy03 {
    public static void main(String[] args) {
        int num = jc(5);
        System.out.println(num);
    }
    //使用递归
    private static int jc(int n) {
        if(n==1){
            return 1;
        }
        return n*jc(n-1);
    }


}
