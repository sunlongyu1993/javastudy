package com.testfan.javastudy.Day0425.Demo02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210426
 * 序列化集合
 */
public class Demo01Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        Person p1 = new Person("sly1",28);
        Person p2 = new Person("sly2",38);
        Person p3 = new Person("sly3",48);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\Person.txt"));
        oos.writeObject(list);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\code\\slycode\\maven_project\\src\\main\\java\\com\\testfan\\javastudy\\file\\Person.txt"));
        Object obj = ois.readObject();
        ArrayList<Person> list2 = (ArrayList<Person>)obj;
        for (Person person : list2) {
            System.out.println(person);
        }
        ois.close();
        oos.close();


    }
}
