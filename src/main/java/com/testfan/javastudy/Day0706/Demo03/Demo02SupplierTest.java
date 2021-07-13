package com.testfan.javastudy.Day0706.Demo03;

import java.util.function.Supplier;

/**
 * @author 孙珑瑜
 * @version 210713
 * 常用的函数式接口-Supplier
 */
public class Demo02SupplierTest {
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    };

    public static void main(String[] args) {
        int maxvalue =getMax(()->{
            int[] arr ={100,990,-10,23,65,85,-98};
            int max =arr[0];
            for (int i : arr) {
                if (i>max){
                    max=i;
                }
            }
            return max;
        }) ;
        System.out.println(maxvalue);
    }
}
