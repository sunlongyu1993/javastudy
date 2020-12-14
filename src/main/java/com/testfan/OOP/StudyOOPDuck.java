package com.testfan.OOP;

/**
 * @author 孙珑瑜
 * @version 20201012
 */
public class StudyOOPDuck {
    public static int a = 0;
    public  int b = 10;

    static {
        System.out.println("静态代码块");
    }

    public void add(){
        System.out.println("实例方法");
    }
    public static void sub(){
        System.out.println("静态方法");
    }



    public static void main(String[] args) {
        StudyOOPDuck.sub();

        StudyOOPDuck studyOOPDuck = new StudyOOPDuck();
        studyOOPDuck.add();

    }
}
