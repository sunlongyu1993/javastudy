package com.testfan.javastudy.Day0302.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210302
 */
public class Zi extends Fu {

    @Override
    public void method() {
        System.out.println("这是子类方法覆盖重新父类方法");
    }
    public void methodZi() {
        System.out.println("子类特有方法");
    }
}
