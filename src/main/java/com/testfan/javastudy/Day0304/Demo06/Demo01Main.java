package com.testfan.javastudy.Day0304.Demo06;

/**
 * @author 孙珑瑜
 * @version 20210306
 * 类作为成员变量
 */
public class Demo01Main {
    public static void main(String[] args) {
        Hero hero = new Hero();//创建一个英雄角色
        hero.setName("缪斯");// 为英雄起名字，并设置年龄
        hero.setAge(18);

        Weapon weapon = new Weapon("真神之剑");//创建一个武器对象
        hero.setWeapon(weapon);//为英雄配备一个武器
        hero.attack();

    }
}
