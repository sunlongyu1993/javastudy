package com.testfan.BasicStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20201010
 */
public class HashMaplianxi2 {
    public static void main(String[] args) {
        //录入本班学员姓名，成绩，自动计算平均分，并且得出第一名

        //用ArrayList 来存储全班学员
        ArrayList<HashMap<String,Object>> stus = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);// 获取控制台的输入内容，用来收集学员信息
        for (int i = 0; i <2 ; i++) {
            System.out.println("请输入姓名:");
            String name = scanner.next();//获取控制台输入，并赋值给name
            System.out.println("请输入成绩:");
            double score = scanner.nextDouble();//获取控制台输入，并赋值给score

            //对于学员来说，一个是姓名，一个是成绩
            // 用map 来表示一个单独的学员
            HashMap<String,Object> stu = new HashMap<>();
            stu.put("name",name);
            stu.put("score",score);

            //将每一个学员的姓名以及成绩添加到ArrayList的集合中
            stus.add(stu);
        }
        System.out.println(stus);

        //自动计算平均分
        //平均分=全班总成绩/全班人数总和
        double sum = 0;
        //遍历方法一，来获取成绩总和
//        for (int i = 0; i <stus.size() ; i++) {
//            HashMap<String, Object> tempstu = stus.get(i);
//            double score = (double) tempstu.get("score");
//            sum += score;
//        }
        //遍历方法二，来获取成绩总和
        for (HashMap<String,Object> stu:stus) {
            double score= (double) stu.get("score");
            sum += score;
        }
        System.out.println("总分:"+sum);//总分

        double avgscore = sum/stus.size();
        System.out.println("平均分分:"+avgscore);

        //第三步：得出第一名.并打印第一名的成绩以及姓名
        //找成绩中的最大值
        double max = (double) stus.get(0).get("score");
        for (HashMap<String,Object> stu:stus) {
            // 得到学员成员
            double score= (double) stu.get("score");
            //获取学员成绩的最大值
            max = Math.max(max, score);
        }
        System.out.println("学员的成绩最高分:"+max);

        // 遍历：找到成绩，如果成绩和最高分一致，就打印出来姓名和成绩
        for (HashMap<String,Object> stu:stus) {
            double score= (double) stu.get("score");
            if(score == max){
                System.out.println("第一名的姓名:"+stu.get("name"));
                System.out.println("第一名的成绩:"+stu.get("score"));
            }
        }




        //对于学员来说，一个是姓名，一个是成绩
//        Map<String,Object> stu1 = new HashMap<>();
//        stu1.put("name",name);
//        stu1.put("score",score);
//        Map<String,Object> stu2 = new HashMap<>();
//        stu2.put("name",name);
//        stu2.put("score",score);
//        Map<String,Object> stu3 = new HashMap<>();
//        stu3.put("name",name);
//        stu3.put("score",score);

//        ArrayList<Map<String,Object>> arrayList = new ArrayList<>();
//        arrayList.add(stu1);
//        arrayList.add(stu2);
//        arrayList.add(stu3);
    }
}
