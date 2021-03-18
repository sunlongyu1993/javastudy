package com.testfan.javastudy.Day0317.Demo04;

import java.util.HashSet;

/**
 * @author 孙珑瑜
 * @version 20210318
 */
public class Demo02Main {
    public static void main(String[] args) {
        HashSet<Person> setperson = new HashSet<>();
        Person person1 = new Person(18,"sly1");
        Person person2 = new Person(28,"sly2");
        Person person3 = new Person(28,"sly2");
        setperson.add(person1);
        setperson.add(person2);
        setperson.add(person3);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());

        System.out.println(person3 == person2);// 比较的地址值，false ,不是同一个对象
        System.out.println(person3.equals(person2));//重写了equals，比较的是哈希值，true

        System.out.println(setperson);
    }
}
