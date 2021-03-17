package com.testfan.javastudy.Day0315.Demo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210316
 * 综合练习——斗地主
 */
public class demo02Generic {
    public static void main(String[] args) {
        //1、准备牌
        List<String> poker = new ArrayList<>();
        String[] colors = {"Black","Red","Mei","Fang"};
        String[] numbers ={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        poker.add("大王");
        poker.add("小王");
        for (String number:numbers) {
            for (String color:colors) {
                System.out.println(color+number);
                poker.add(color+number);
            }
        }
        //2、洗牌
        Collections.shuffle(poker);
        System.out.println(poker);

        //3、发牌：定义4个集合，存储玩家和底牌
        ArrayList<String> listA = new ArrayList();
        ArrayList<String> listB = new ArrayList();
        ArrayList<String> listC = new ArrayList();
        ArrayList<String> listD = new ArrayList();
        /**
         * 遍历poker集合，获取每一张牌；
         * 使用poker集合的索引%3给3个玩家轮流发牌，剩余3张给底牌
         * 注意：先判断底牌（i>=51）,否则牌就发没了；
         */
        for (int i = 0; i <poker.size() ; i++) {
            String p = poker.get(i);//获取每一张牌
            //轮流发牌
            if (i >=51){//给底牌发牌
                listD.add(p);
            }
            else if (i%3 == 0){
                listA.add(p);
            }
            else if (i%3 == 1){
                listB.add(p);
            }
            else if (i%3 == 2){
                listC.add(p);
            }
        }
        //4、看牌
        System.out.println(listA);
        System.out.println(listB);
        System.out.println(listC);
        System.out.println(listD);

    }
}
