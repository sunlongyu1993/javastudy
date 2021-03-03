package com.testfan.javastudy.Day0303.Demo01;

/**
 * @author 孙珑瑜
 * @version 20210303
 */
public class Demo01Main {
    public static void main(String[] args) {
        //对象的向上转型，就是：父类引用指向子类对象
        Animal animal= new Cat();//本来创建的是一只猫
        animal.eat();


        //向下转型
        Cat cat = (Cat)animal;
        cat.catchMouse();//猫捉老鼠
        //错误的向下转型
        //本来是一只猫，现在非要当做狗
        //错误写法，编译不会报错，运行会报错
        //java.lang.ClassCastException 类转化异常
//        Dog dog =(Dog)animal;
    }
}
