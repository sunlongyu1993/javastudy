package com.testfan.javastudy.Day0706.Demo03;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author 孙珑瑜
 * @version 210713
 * 常用的函数式接口-Consumer
 */
public class Demo03Consumer {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("孙珑瑜",(String name)->{
//            System.out.println(name);
            String rename=new StringBuffer(name).reverse().toString();
            System.out.println(rename);
        });
    }

}
