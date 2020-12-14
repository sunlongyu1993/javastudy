package com.testfan.BasicStudy;

/**
 * @author 孙珑瑜
 * @version 20200928
 */
public class StudyOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);

        float c = 5.1f;
        System.out.println(a+c);

        int d = 3;
        // 因为a和d都是int类型，所以结果也是int类型，所以结果保留整数位
        System.out.println(a/d);

        double e = 3;
        System.out.println(a/e);

        System.out.println(a%d);

        //一般常用
        System.out.println(d++);
        System.out.println(++d);

        int f = 6;
        System.out.println(f--);
        System.out.println(--f);
        System.out.println(f != d);
        System.out.println(f > d);
        System.out.println(f < d);
        System.out.println(f <= d);
        System.out.println(f >= d);
        System.out.println("==============逻辑运算符===============");
        int a1 = 10,a2 = 20,a3= 30;
        System.out.println(a1>a2 && a1< a3);
        System.out.println(a1>a2 || a1< a3);
        System.out.println(!true);
        System.out.println(!false);

    }
}
