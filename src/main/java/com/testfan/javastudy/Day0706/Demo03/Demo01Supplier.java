package com.testfan.javastudy.Day0706.Demo03;

import java.util.function.Supplier;

/**
 * @author 孙珑瑜
 * @version 210713
 * 常用的函数式接口-Supplier
 */
public class Demo01Supplier {


    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        String str = getString(()->{ return "胡歌"; });
        System.out.println(str);
        String str2 = getString(()-> "胡歌");
        System.out.println(str2);
    }
}
