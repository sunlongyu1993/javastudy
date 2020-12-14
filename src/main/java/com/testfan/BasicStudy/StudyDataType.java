package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200928
 */
public class StudyDataType {
    public static void main(String[] args) {
        System.out.println("复习");
        //从-128到127
        byte a = 20;
        System.out.println(a);
        //
        short b = 789;
        System.out.println(b);

        // 表示手机号-长整型
        long c = 18810677206L;
        System.out.println(c);

        //一般常用
        int i = 1234567;
        System.out.println(i);

        float f = 1.345678901f;
        System.out.println(f);
        double d = 1.345678901;
        System.out.println(d);

        //一般常用boolean
        boolean flag = true;
        boolean flag2 = false;

        //char 必须是用单引号，并且只能是一个字符
        char cha = 'a';
        System.out.println(cha);


    }
}
