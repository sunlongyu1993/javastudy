package com.testfan.javastudy.day0220.staticstudy;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class DemoStudent {
    public static void main(String[] args) {
        Student.room ="101教室";
        Student two =new Student("sly2",28);
        System.out.println(two.getName()+":"+two.getAge()+":"+two.getId()+":"+Student.room);

        Student one =new Student("sly1",18);
        System.out.println(one.getName()+":"+one.getAge()+":"+one.getId()+":"+Student.room);

    }
}
