package com.testfan.javastudy.day0220;

import java.util.ArrayList;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class ArraylistTest3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("sly1");
        list.add("sly2");
        list.add("sly3");
        System.out.println(list);
        printArrayList(list);
    }
    public static void printArrayList(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (i ==(list.size()-1)){
                System.out.print(s+"}");

            }
            else {
                System.out.print(s+"@");

            }
        }
    }
}
