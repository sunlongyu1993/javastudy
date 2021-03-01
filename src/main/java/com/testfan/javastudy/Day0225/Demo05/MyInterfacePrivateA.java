package com.testfan.javastudy.Day0225.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210301
 */
public interface MyInterfacePrivateA {
    public default void MethodDefault1(){
        System.out.println("默認方法1");
//        MethodCommon();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");



    }
    public default void MethodDefault2(){
        System.out.println("默認方法2");
//        MethodCommon();
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
    }
//    public default void MethodCommon(){
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
//    private void MethodCommon(){
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }

}
