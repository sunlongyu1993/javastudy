package com.testfan.javastudy.Day0315.Demo03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 孙珑瑜
 * @version 20210315
 * 泛型
 */
public class Demo03Fanxing {
    public static void main(String[] args) {
//        demo01();
    }
    public static void demo01(){
        ArrayList list = new ArrayList();
        list.add("aaaa");
        list.add(123) ;

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);

            String str=(String)obj;
            int len = str.length();
            System.out.println(len);
        }


    }
    public static void demo02(){

    }
}
