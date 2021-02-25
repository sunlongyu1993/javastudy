package com.testfan.javastudy.Day0225.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210225
 */
public class User {
    private String name;//姓名
    private int money;//余额，当前用户拥有的钱数

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }
    //显示用户有多少钱
    public void showMoney(){
        System.out.println("我叫："+name+",我有："+money);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
