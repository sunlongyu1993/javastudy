package com.testfan.javastudy.day0220;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class DemoArray {
    public static void main(String[] args) {
        Student[] stu= new Student[3];
        Student stu1 = new Student("sly",12);
        Student stu2 = new Student("sly2",13);
        Student stu3 = new Student("sly3",14);
        stu[0]=stu1;
        stu[1]=stu2;
        stu[2]=stu3;
        System.out.println(stu[0].getName());
        System.out.println(stu[1].getName());
        System.out.println(stu[2].getName());
    }

}
