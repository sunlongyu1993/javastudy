package com.testfan.javastudy.Day0323.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210324
 */
public class RegisterException extends /*Exception*/ RuntimeException{
    public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);
    }
}
