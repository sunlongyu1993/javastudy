package com.testfan.javastudy.Day0319.Demo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20210323
 */
public class MapTest1 {
    public static void main(String[] args) {
        Map<Character,Integer> strmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String strinput = sc.next();

        for (char s:strinput.toCharArray()){
            if(strmap.containsKey(s)){//key存在
                Integer value = strmap.get(s);
                value++;
                strmap.put(s,value);
            }
            else {//key不存在
                strmap.put(s,1);
            }
        }
        System.out.println(strmap);


    }
}
