package com.testfan.BasicStudy;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20200930
 */
public class homework0813 {
    
//输入日期，判断日期是这一年的第几天，比如输入2020-1-13，打印结果是2020-1-13是2020年的第13天
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入日期：yyyy-MM-dd");
//        String date = scanner.next();
//
//        String[] split = date.split("-");
//        int year = Integer.parseInt(split[0]);
//        int mon = Integer.parseInt(split[1]);
//        int day = Integer.parseInt(split[2]);
//        int day_m =0;
//
//        if((year%4==0 && year%100 !=0)|| (year %400 ==0)){
////            System.out.println("是闰年");
//            int[] mont ={0,31,29,31,30,31,30,31,31,30,31,30,31};
//            for (int i = 0; i <mon ; i++) {
//                day_m += mont[i];
//            }
//            int days = day+day_m;
//            System.out.println("是"+year+"年的第"+days+"天");
//
//        }
//
//        else {
////            System.out.println("不是闰年");
//            int[] mont ={0,31,28,31,30,31,30,31,31,30,31,30,31};
//            for (int i = 0; i <mon ; i++) {
//                day_m += mont[i];
//            }
//            int days = day+day_m;
//            System.out.println("是"+year+"年的第"+days+"天");
//        }
        test2();
    }

    //统计一个字符串里的mtx单词出现的次数，
    // 比如字符串this is mtx autotest,
    // shamo is very good,
    // mtx is very good,
    // i like mtx shamo teacher
    public static void test2(){
        String s = "this is mtx autotest,shamo is very good,mtx is very good,i like mtx shamo teacher";
        String[] split = s.trim().split(" |,");
        int count =0;
        for (String str:split) {
            if(str.equals("mtx")){
                count++;
            }
        }
        System.out.println(count);
    }

}
