package com.testfan.javastudy.day0220;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class ScannerStudy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第1个数字：");
        int a = scanner.nextInt();
        System.out.println("请输入第2个数字：");
        int b = scanner.nextInt();

        System.out.println("请输入第3个数字：");
        int c = scanner.nextInt();
        //计算2个输入的数字之和
        //        int c =a + b;
        //        System.out.println(c);
        //比较输入的3个数字的最大值
        int temp = a>b?a:b;
        int max =temp>c?temp:c;
        System.out.println(max);

    }
}
