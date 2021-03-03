package com.testfan.javastudy.Day0303.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Demo02Instanceof {
    public static void main(String[] args) {
        Animal animal = new Dog();//本来是一只狗
        animal.eat();//狗吃骨头
        //如果希望调用子类特有方法，需要向下转型
        //判断一下父类引用annimal 本来是不是dog
        if (animal instanceof Dog){
            Dog dog =(Dog)animal;
            dog.watchHose();
        }
//        判断一下父类引用annimal 本来是不是Cat
        if (animal instanceof Cat){
            Cat cat =(Cat)animal;
            cat.catchMouse();
        }
        giveAPet(new Dog());

    }

    public static void giveAPet(Animal animal){
        if (animal instanceof Dog){
            Dog dog = (Dog)animal;
            dog.watchHose();
        }
        if (animal instanceof Cat){
            Cat cat = (Cat)animal;
            cat.catchMouse();
        }
    }
}
