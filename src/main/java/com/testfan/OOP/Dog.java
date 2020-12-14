package com.testfan.OOP;

/**
 * @author 孙珑瑜
 * @version 20201012
 */
// 继承（实现）接口类：implements StudyInterface
public class Dog extends Animal implements StudyInterface{

    // 子类需要实现父类的构造方法
    public Dog(String color, String name, int weight) {
        super(color, name, weight);
    }

    public static void main(String[] args) {

        Dog dog = new Dog("黑色","哈士奇",2);
        // 继承父类的方法
        dog.cry("汪汪汪");
//        dog.name = "哈士奇";
//        dog.color = "黑色";
//        dog.weight = 2;
    }

    //重写，在实现接口的时候，就必须实现接口中的方法
    // 发生在子类和父类直接，这是必须需要重新的
    @Override
    public void walk() {
        System.out.println(this.name +"跑得快");
    }
}
