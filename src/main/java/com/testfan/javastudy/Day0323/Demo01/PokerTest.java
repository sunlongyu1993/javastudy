package com.testfan.javastudy.Day0323.Demo01;

import java.util.*;

/**
 * @author 孙珑瑜
 * @version 20210323
 */
public class PokerTest {
    public static void main(String[] args) {
        //1、准备牌
        HashMap<Integer,String> poker= new HashMap<>();//存储poker牌

        ArrayList<Integer> pokerIndex = new ArrayList<>();//存储poker牌的key
        //定义2个集合，存储poker的花色和数字
        List<String> colors = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        colors.add("Black");
        colors.add("Red");
        colors.add("Mei");
        colors.add("Fang");
        numbers.add("2");
        numbers.add("A");
        numbers.add("K");
        numbers.add("Q");
        numbers.add("J");
        numbers.add("10");
        numbers.add("9");
        numbers.add("8");
        numbers.add("7");
        numbers.add("6");
        numbers.add("5");
        numbers.add("4");
        numbers.add("3");

        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套2个集合
            for (String number : numbers) {
                for (String color : colors) {
                    poker.put(index,color+number);
                    pokerIndex.add(index);
                    index++;
                }
            }
//        System.out.println(poker);
//        System.out.println(pokerIndex);
        //2、洗牌
        Collections.shuffle(pokerIndex);
        System.out.println(pokerIndex);
//      3、发牌
        ArrayList<Integer> play01 = new ArrayList<>();
        ArrayList<Integer> play02 = new ArrayList<>();
        ArrayList<Integer> play03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);//根据索引
            if(i>=51){
                dipai.add(in);
            }
            else if(i%3 ==0){
                play01.add(in);
            }
            else if(i%3 ==1){
                play02.add(in);
            }
            else if(i%3 ==2){
                play03.add(in);
            }
        }
        System.out.println(play01);
        System.out.println(play02);
        System.out.println(play03);
        System.out.println(dipai);
        //4、排序，对每一个玩家以及底牌进行排序
        Collections.sort(play01);
        Collections.sort(play02);
        Collections.sort(play03);
        Collections.sort(dipai);
        //看牌
        System.out.println(play01);
        System.out.println(play02);
        System.out.println(play03);
        System.out.println(dipai);

        lookPoker("sly1",poker,play01);
        lookPoker("sly2",poker,play02);
        lookPoker("sly3",poker,play03);
        lookPoker("底牌",poker,dipai);
    }

    /**
     *
     * @param name:玩家的名称
     * @param poker：存储牌的map的poker集合
     * @param list：存储玩家或是底牌的List集合
     */
    public static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list){
        System.out.print(name+":");//输出玩家的牌不换行
        for (Integer pokerIndes : list) {
            String pokerValue = poker.get(pokerIndes);//遍历玩家或者底牌的集合，获取牌的索引
            System.out.print(pokerValue+" ");
        }
        System.out.println();//打印完每一个玩家的牌，换行
    }

}
