package com.testfan.javastudy.Day0706.Demo02;

/**
 * @author 孙珑瑜
 * @version 210712
 */
@FunctionalInterface
public interface MessageBuilder {
    //定义一个拼接消息的抽象方法，返回被拼接的消息
    public abstract String builderMessage();

}
