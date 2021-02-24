package com.testfan.javastudy.day0220.ExtendStudy.Two;

/**
 * @author 孙珑瑜
 * @version 20210223
 */
public class Demo02ExtentTests {
    public static void main(String[] args) {
        ZiTest ziTest = new ZiTest();
        System.out.println(ziTest.num);

        Futest futest = new Futest();
        System.out.println(futest.num);

        ziTest.Zimethod();
        ziTest.Fumethod();

    }
}
