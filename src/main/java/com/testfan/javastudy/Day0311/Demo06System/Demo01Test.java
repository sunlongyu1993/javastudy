package com.testfan.javastudy.Day0311.Demo06System;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 孙珑瑜
 * @version 20210315
 */
public class Demo01Test {
    public static void main(String[] args) {
//      demo01();
        demo02();

    }
    public static void demo01(){
        long e = System.currentTimeMillis();

        for (int i = 1; i <9999 ; i++) {
            System.out.println(i);
        }
        long l = System.currentTimeMillis();
        System.out.println("共耗时"+(l-e)+"毫秒");
    }
    public static void demo02(){
        int[] src ={1,2,3,4,5};
        int[] dest ={6,7,8,9,10};
        System.out.println("复制前数组："+ Arrays.toString(dest));
        System.arraycopy(src,0,dest,0,3);
        System.out.println("复制后数组："+Arrays.toString(dest));
    }
}
