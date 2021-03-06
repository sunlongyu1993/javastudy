package com.testfan.javastudy.Day0304.Demo06;

/**
 * @author 孙珑瑜
 * @version 20210306
 * 类作为成员变量类型
 */
public class Hero {
    private String  name ;//英雄的名字
    private int age;//英雄的年龄
    private Weapon weapon;//英雄的武器

    public Hero() {
    }

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    //自定义一个方法
    public void attack(){
        System.out.println("年龄："+age+"的，名字为："+name+"用"+weapon.getCode()+"供给敌方。");
    }
}
