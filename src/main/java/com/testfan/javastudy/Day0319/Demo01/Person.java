package com.testfan.javastudy.Day0319.Demo01;

import java.util.Objects;

/**
 * @author 孙珑瑜
 * @version 20210318
 */
public class Person implements Comparable<Person>{
    private int age;
    private String name;
    public Person() { }
    public Person(int age, String name) {
        this.age = age;
        this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    @Override//重新排序规则
    public int compareTo(Person o) {
//        return 0;//认为元素都是相同的
        //自定义比较的规则：比较两个人的年龄，（this,参数Person）
        return this.getAge()-o.getAge();//年龄升序升序
    }
}
