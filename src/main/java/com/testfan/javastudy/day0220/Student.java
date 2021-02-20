package com.testfan.javastudy.day0220;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class Student {
    //成员变量
    private  String name;
    private int age;
    //无参构造方法
    public Student(){
        System.out.println("无参构造方法执行了");
    }
//    有参数构造方法
public Student(String name,int age){
    System.out.println("有参构造方法执行了");
    this.name=name;
    this.age =age;
}
//get&set 方法
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}
