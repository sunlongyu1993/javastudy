package com.testfan.javastudy.Day0225.Demo01;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class Member extends User {

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }
    //普通成员收红包
    public void receive(ArrayList<Integer> redpacket){
        //从多个红包中随机抽取一个
        //随机抽取一个集合中的索引编号
        int index =new Random().nextInt(redpacket.size());
        //根据索引，从集合当中删除，并且得到被删除的红包，给自己
        int delta = redpacket.remove(index);
        //当前成员本来的金额；
        int money = super.getMoney();
        //加法，将收入红包后的金额重新设置给普通成员
        super.setMoney(money+delta);
    }
}
