package com.testfan.javastudy.day0220.staticstudy;

/**
 * @author 孙珑瑜
 * @version 20210220
 */
public class Student {
    private int age;
    private String name;
    static String room;

    private int id;//学号
    private static int idCounter =0;//学号计数器，每当new一个新对象，计数器+1

    public Student() {
        this.id = ++idCounter;

    }

    public Student( String name, int age) {
        this.id = ++idCounter;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public static String getRoom() {
//        return room;
//    }
//
//    public static void setRoom(String room) {
//        Student.room = room;
//    }
}
