package com.testfan.BasicStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20201010
 */
public class HashMaplianxi1 {
    public static void main(String[] args) {
        //练习
        Map<String,String> stu1 = new HashMap<>();
        stu1.put("name","sly2");
        stu1.put("age","19");
        stu1.put("job","teacher2");

        Map<String,String> stu2 = new HashMap<>();
        stu2.put("name","sly2");
        stu2.put("age","19");
        stu2.put("job","teacher2");

        Map<String,String> stu3 = new HashMap<>();
        stu3.put("name","sly2");
        stu3.put("age","19");
        stu3.put("job","teacher2");

        ArrayList<Map<String,String>> arrayList = new ArrayList<>();
        arrayList.add(stu1);
        arrayList.add(stu2);
        arrayList.add(stu3);

        System.out.println(arrayList);
    }
}
