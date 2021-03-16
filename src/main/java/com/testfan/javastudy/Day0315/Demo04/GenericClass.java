package com.testfan.javastudy.Day0315.Demo04;

/**
 * @author 孙珑瑜
 * @version 20210316
 */
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
