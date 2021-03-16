package com.testfan.javastudy.Day0315.Demo05;

/**
 * @author 孙珑瑜
 * @version 20210316
 * 主函数——使用实现类
 */
public class Demo01Main {
    public static void main(String[] args) {
        GenericInterfaceImpl ge = new GenericInterfaceImpl();
        ge.method("接口的实现类，泛型是字符串");


        GenericInterfaceImpl2<Integer> gee = new GenericInterfaceImpl2<>();
        gee.method(1);
    }
}
