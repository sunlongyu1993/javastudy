package com.testfan.javastudy.Day0319.Demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 孙珑瑜
 * @version 20210318
 */
public class Demo02Collections {
    public static void main(String[] args) {
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(5);
//        list1.add(3);
//        list1.add(6);
//        System.out.println(list1);
//        Collections.sort(list1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });

        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student(18,"d迪丽热巴"));
        list2.add(new Student(20,"b古力娜扎"));
        list2.add(new Student(17,"c杨幂"));
        list2.add(new Student(18,"a杨幂"));
        System.out.println(list2);
        //一个规则
//        Collections.sort(list2, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o2.getAge();//按照年龄升序
//            }
//        });
        //根据年龄升序排列，如果年龄相同，根据名字的首字母排序
//        Collections.sort(list2, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o2.getAge();//按照年龄升序
//            }
//        });
//        根据年龄升序排列，如果年龄相同，根据名字的首字母排序
        Collections.sort(list2, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result =o1.getAge()-o2.getAge();//按照年龄升序排列
                if(result ==0){//如果两个人年龄一样，则根据姓名的首字母升序排列
                    result= o1.getName().charAt(0)-o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list2);
    }
}
