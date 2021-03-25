package com.testfan.javastudy.Day0323.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210324
 */
public class Demo1MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("sly1");
        Person p2 = new Person("sly2");
        p1.run();
        p2.run();


    }

}
