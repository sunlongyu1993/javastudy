package com.testfan.javastudy.day0220;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class DemoStudent {
    public static void main(String[] args) {
        Student student = new Student();//无参构造
        System.out.println("=============================");

        Student student1 = new Student("sly",19);//全参构造
        System.out.println(student1.getName()+":"+student1.getAge());

        student1.setAge(21);
        System.out.println(student1.getName()+":"+student1.getAge());

    }

}
