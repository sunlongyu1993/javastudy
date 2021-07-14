package com.testfan.javastudy.Day0706.Demo03;

import java.util.function.Consumer;

/**
 * @author 孙珑瑜
 * @version 210713
 * 常用的函数式接口-Consumer
 */
public class Demo04ConsumerAndThen {
    public static void method1(String name, Consumer<String> con1,Consumer<String> con2){
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }

    public static void main(String[] args) {
        method1("sly",
                (name)->{
                    System.out.println(name.toUpperCase());
                },
                (name)->{
                    System.out.println(name.toLowerCase());
                }
                );
    }

}
