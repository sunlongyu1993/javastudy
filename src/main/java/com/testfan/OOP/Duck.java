package com.testfan.OOP;

/**
 * @author 孙珑瑜
 * @version 20201012
 */
public class Duck extends Animal {
//子类需要实现父类的构造方法
    public Duck(String color, String name, int weight) {
        super(color, name, weight);
    }

    // 子类可以有自己的属性以及方法
    public int legs;
    public void swimming(){
        System.out.println(this.name + "会游泳");
    }

    @Override
    public void cry(String name){
        super.cry("呱呱呱");// 父类的
        this.cry("呱呱呱");// 子类的方法
        System.out.println(this.name +"子类");
    }
    // 重写：子类方法名称和父类的方法名称一致；多态的一种形式
    public void cry(){
        System.out.println(this.name +"子类");
    }



    public static void main(String[] args) {
        Duck duck = new Duck("黑色","唐老鸭",2);
        duck.cry("呱呱呱");

        //duck 类中没有定义以下属性，可以继承父类的属性
//        duck.name = "唐老鸭";
//        duck.color = "黑色";
//        duck.weight = 2;
        duck.cry();
    }
}
