package com.testfan.javastudy.Day0225.Demo01;

import java.util.ArrayList;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class Demo01Main {
    public static void main(String[] args) {
        Manager manager = new Manager("群主",100);
        Member one = new Member("普通成员A",0);
        Member two= new Member("普通成员B",10);
        Member three = new Member("普通成员C",20);

        manager.showMoney();
        one.showMoney();
        two.showMoney();
        three.showMoney();


        ArrayList<Integer> sendRedList = manager.send(20, 3);
        one.receive(sendRedList);
        two.receive(sendRedList);
        three.receive(sendRedList);

        manager.showMoney();
        one.showMoney();
        two.showMoney();
        three.showMoney();

    }
}
