package com.testfan.javastudy.day0220;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class ArraylistTest4 {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        for (int i = 0; i <20; i++) {
            Random random = new Random();
            int num = random.nextInt(100);
            bigList.add(num);
        }
        ArrayList<Integer> smalllist = getList(bigList);
        System.out.println(smalllist);
    }
//这个方法接收大集合参数，返回小集合结果
    public static ArrayList<Integer> getList(ArrayList<Integer> bigList){
        ArrayList<Integer> smallList = new ArrayList<>();//创建一个小集合，用来接收是偶数
        for (int i = 0; i < bigList.size(); i++) {
            Integer bignum = bigList.get(i);
            if(bignum %2 ==0){
                smallList.add(bignum);
            }
        }
        return smallList;
    }
}
