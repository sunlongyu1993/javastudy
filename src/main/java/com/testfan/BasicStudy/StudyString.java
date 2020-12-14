package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 2020928
 */
public class StudyString {
    public static void main(String[] args) {
        String s = "hello mtx hello mtx hello mtx hello mtx";
        System.out.println(s);

        int len = s.length();
        System.out.println(len);

        float f = 2.3f;
        int a = 10;
        String s1 = "马同学";
        System.out.printf("浮点数：%f,整数：%d,字符串：%s",f,a,s1);
        System.out.println("浮点数:"+f+"整数:"+a+"字符串："+s1);

        String s2 = " 码同学 ";
        System.out.println(s2.trim());// 去掉前后端的空格

        // 字符串截取，
        String s3 = "码同学你好";
        System.out.println(s3.substring(0,3));
        // 替换
        System.out.println(s3.replace("码同学","testfan"));
        String s4 = "hello mtx hello mtx hello    mtx hello mtx";
        System.out.println(s4.replace(" ",""));
        //替换第一个值
        System.out.println(s4.replaceFirst("hello","HELLO"));

        System.out.println(s4.contains("testfan"));
        System.out.println(s4.toUpperCase());//换成大写
        System.out.println(s4.toLowerCase());//换成小写

        //字符串的比较
        String s5 = "abcdef";
        String s6 = "ABCDEF";
        System.out.println(s5.equals(s6));
        System.out.println(s5.equalsIgnoreCase(s6));

        // 分割
        String str = "小学,初中,高中,大学";
        System.out.println(str.split(",")[0]);
        // 有多个分隔符，用| 隔开
        String str1 = "小学.初中.高中,大学";
        System.out.println(str1.split("\\.|,")[2]);

        String name = "孙龙玉";
        System.out.println(name.startsWith("孙"));

        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.append("d");
        System.out.println(stringBuffer);
        //
        String homework = "1080*1920";
        System.out.println(homework.split("\\*")[0]);
        System.out.println(homework.split("\\*")[1]);


    }
}
