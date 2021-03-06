package com.testfan.javastudy.Day0304.Demo06;

/**
 * @author 孙珑瑜
 * @version 20210306
 * 武器类作为英雄的一个成员变量
 */
public class Weapon {
    private String code ;//武器的代号

    public Weapon() {
    }

    public Weapon(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
