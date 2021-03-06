package com.testfan.javastudy.Day0304.Demo08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210306
 */
public class DemoInterface {
    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> new_addlists = addlists(list);
        for (int i = 0; i < new_addlists.size(); i++) {
            System.out.println(new_addlists.get(i));
        }

    }
    public static List<String> addlists(List<String> list){
        list.add("sly1");
        list.add("sly2");
        list.add("sly3");
        list.add("sly4");
        return list;
    }
}
