package com.testfan.javastudy.Day0225.Demo01;

import java.util.ArrayList;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class Manager extends User{

    //群主,有发红包的
    public Manager(){}

    public Manager(String name, int money) {
        super(name, money);
    }//有参构造，调用父类的方法

    public ArrayList<Integer> send(int totalMoney,int count){//totalMoney 要发送的红包金额
        ArrayList<Integer> redpacket =new ArrayList<>();
        //安全检查
        //首先看群主自己有多少钱
        int leftMoney = super.getMoney();//群主当前余额
        if(totalMoney>leftMoney){
            System.out.println("余额不足，返回一个空集合");
            return redpacket;
        }
        //扣钱，重新设置余额
        super.setMoney(leftMoney-totalMoney);

        //发红包需要分成若干份
        int ave = totalMoney/count;
        int mod = totalMoney%count;//余数，被甩下的零头
        //零头放到最后一个红包中
        //下面把红包一个个放到集合中
        for (int i = 0; i < count-1; i++) {
            redpacket.add(ave);
        }
        int last = ave+mod;
        redpacket.add(last);
        return redpacket;

    }
}

