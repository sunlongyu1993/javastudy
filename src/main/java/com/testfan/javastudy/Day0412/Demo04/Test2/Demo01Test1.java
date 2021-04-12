package com.testfan.javastudy.Day0412.Demo04.Test2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 孙珑瑜
 * @version 20210412
 * 练习2：有参数有返回值的练习
 */
public class Demo01Test1 {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("sly1",38),
                new Person("sly2",19),
                new Person("sly3",20)
        };
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
        //Lambda写法
        Arrays.sort(arr,
                (Person o1,Person o2)->{ return o1.getAge()-o2.getAge(); }
                );

        //Lambda省略的写法
        Arrays.sort(arr,
                (o1,o2)-> o1.getAge()-o2.getAge()
                );

        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
