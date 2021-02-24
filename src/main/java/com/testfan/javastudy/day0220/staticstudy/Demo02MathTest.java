package com.testfan.javastudy.day0220.staticstudy;

/**
 * @author 孙珑瑜
 * @version 20210223
 */
public class Demo02MathTest {
    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        int count =0;
        for (int i = (int)min; i <max ; i++) {
            if (Math.abs(i)>6 || Math.abs(i)<2.1){
                count++;
                System.out.println(i);
            }
        }
        System.out.println("统计的数量："+count);
    }
}
