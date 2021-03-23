package com.testfan.javastudy.Day0323.Demo02;

import java.util.Objects;

/**
 * @author 孙珑瑜
 * @version 20210323
 */
public class ObjectsStudy {
    public static void main(String[] args) {
        method(null);
    }
    public static void method(Object obj){
        Objects.requireNonNull(obj);
    }
}
