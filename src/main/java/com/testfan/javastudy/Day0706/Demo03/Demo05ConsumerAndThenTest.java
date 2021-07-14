package com.testfan.javastudy.Day0706.Demo03;

import java.util.function.Consumer;

/**
 * @author 孙珑瑜
 * @version 210714
 */
public class Demo05ConsumerAndThenTest {
    public static void method(String s, Consumer<String>con1,Consumer<String>con2){
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        String[] arrs={"迪丽热巴,女","马尔扎哈,男"};
        for (String arr : arrs) {
            method(arr,
                    (s)->{
                //按照指定的格式切割
                        String name=arr.split(",")[0];
                        System.out.print("姓名:"+name);
                    },
                    (s)->{
                        String sex=arr.split(",")[1];
                        System.out.println(",年龄:"+sex+".");
                    }
                    );
        }
    }
}
