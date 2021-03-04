package com.testfan.javastudy.Day0304.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210304
 */
public class Demo01Main {
    public static void main(String[] args) {
        Student student = new Student("赵丽颖");
        System.out.println(student.getName());
        System.out.println(student);

        student = new Student("霍建华");
        System.out.println(student.getName());
        System.out.println(student);
        System.out.println("=====================");

       final Student student2= new Student("高圆圆");//变量当中的地址值是不可变的
        System.out.println(student2.getName());
//        student2 =new Student("赵又廷");

        student2.setName("高圆圆媛媛媛");//变量当中的内容是可变的
        System.out.println(student2.getName());





    }
}
