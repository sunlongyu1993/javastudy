package com.testfan.javastudy.Day0304.Demo02;

/**
 * @author 孙珑瑜
 * @version 20210304
 */
public class Person {
    private final String name /*="鹿晗"*/;//成员变量添加了final关键字，就必须手动赋值


    public Person() {
        this.name ="关晓彤";//使用构造方法赋值
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
