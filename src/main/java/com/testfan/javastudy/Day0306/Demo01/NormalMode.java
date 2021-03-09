package com.testfan.javastudy.Day0306.Demo01;

import com.testfan.javastudy.Day0306.Red.OpenMode;

import java.util.ArrayList;

/**
 * @author 孙珑瑜
 * OpenMode的实现类，平均分发红包
 */
public class NormalMode implements OpenMode {
    @Override
    //totalMoney ：总钱数
    //totalCount:分成几份
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int avg= totalMoney/totalCount;
        int mod = totalMoney% totalCount;
        for (int i = 0; i < totalCount-1; i++) {
            list.add(avg);
        }
        list.add(avg+mod);
        return list;
    }
}
