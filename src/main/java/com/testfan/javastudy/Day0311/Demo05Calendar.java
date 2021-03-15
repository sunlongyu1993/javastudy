package com.testfan.javastudy.Day0311;

import java.util.Calendar;

/**
 * @author 孙珑瑜
 */
public class Demo05Calendar {
    public static void main(String[] args) {
//        Calendar s = Calendar.getInstance();
//        System.out.println(s);
//        demo01();
//        demo02();
        demo03();

    }
    public static void demo01(){
        Calendar s = Calendar.getInstance();
        int i = s.get(Calendar.YEAR);
        System.out.println(i);

        int month = s.get(Calendar.MONTH)+1;
        System.out.println(month);
//        int day = s.get(Calendar.DAY_OF_MONTH);
//        System.out.println(day);
        int day1 = s.get(Calendar.DATE);
        System.out.println(day1);
    }
    public static void demo02(){
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR,2020);
        System.out.println(cal.get(Calendar.YEAR));

        cal.set(Calendar.MONTH,5);
        System.out.println(cal.get(Calendar.MONTH));
    }
    public static void demo03(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR,2);
        System.out.println(cal.get(Calendar.YEAR));
        cal.add(Calendar.MONTH,-1);
        System.out.println(cal.get(Calendar.MONTH));
    }
}
