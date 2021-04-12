package com.testfan.javastudy.Day0412.Demo04.Test3;

/**
 * @author 孙珑瑜
 * @version 20210412
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        //调用invokeCalc方法，方法的参数是一个接口，可以使用匿名内部类
        invokeCalc(10, 20, new Calvulator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        //使用Lambda 表达式简化匿名内部类的书写
        invokeCalc(10,20,(int a, int b)->{return a+b; });

//        使用Lambda的省略版本
        invokeCalc(10,20, (a,b)->a+b);
    }

    /**
     * 定义一个方法，参数传递2个int的整数，参数传递Calvulator的接口
     * @param a
     * @param b
     * @param cal 接口
     * 方法内部调用Calvulator中的方法calc计算2个整数的和
     */
    public static void invokeCalc(int a, int b,Calvulator cal){
        int sum = cal.calc(a,b);
        System.out.println(sum);
    }

}
