package com.testfan.javastudy.Day0306.Demo01;

import com.testfan.javastudy.Day0306.Red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 孙珑瑜
 */
public class RandomMode implements OpenMode {

    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        int leftMoney = totalMoney;
        int leftCount = totalCount;
        for (int i = 0; i < totalCount-1; i++) {
           int money= r.nextInt(leftMoney / leftCount * 2)+1;
           list.add(money);//钱以分为单位
           leftMoney -=money;//剩下的钱越来越少
           leftCount --;//次数也越来越少
        }
        list.add(leftMoney);//最后一个红包，将剩余的钱塞在最后一个红包中
        return list;
    }
}
