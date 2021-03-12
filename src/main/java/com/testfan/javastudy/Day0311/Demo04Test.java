package com.testfan.javastudy.Day0311;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 孙珑瑜
 */
public class Demo04Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入出生年月：yyy-MM-dd");
        String birthday = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Date parse = sdf.parse(birthday);
        long birthdaytime = parse.getTime();
        long currenttime = new Date().getTime();
        long time =currenttime-birthdaytime;
        System.out.println(time/1000/60/60/24);
    }
}
