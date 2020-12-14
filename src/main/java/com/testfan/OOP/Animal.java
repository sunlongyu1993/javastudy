package com.testfan.OOP;

/**
 * @author 孙珑瑜
 * @version 20201012
 */
public class Animal {
    //父类-变量
    public String color;
    public String name;
    public int weight;

    //父类-构造方法
    public Animal(String color,String name,int weight){
        this.color = color;
        this.name = name;
        this.weight = weight;
    }
    public Animal(String name){
        this.name =name;
    }

    // 父类的普通方法
    public void cry(String cry){
        System.out.println(this.name + cry);
    }

}
