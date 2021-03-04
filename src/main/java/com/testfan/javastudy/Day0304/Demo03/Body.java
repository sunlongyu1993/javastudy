package com.testfan.javastudy.Day0304.Demo03;

/**
 * @author 孙珑瑜
 * @version 20210304
 */
public class Body {//外部类


    public class Heart{//成员内部类
        public void beat(){//内部类的方法
            System.out.println("成员内部类，心脏跳动");
            System.out.println("我叫："+name);//正确方法
        }
    }


    private String name;//外部类的成员变量
    public void methodBody(){//外部类的方法
        System.out.println("外部类的用法");
        new Heart().beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
