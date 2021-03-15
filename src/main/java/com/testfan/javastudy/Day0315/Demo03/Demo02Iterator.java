package com.testfan.javastudy.Day0315.Demo03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 孙珑瑜
 * @version 20210315
 * Iterator 迭代器
 */
public class Demo02Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("sly1");
        coll.add("sly2");
        // 多态 接口            实现类对象
        Iterator<String> it = coll.iterator();
//        boolean b = it.hasNext();
//        System.out.println(b);
//        String s = it.next();
//        System.out.println(s);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
