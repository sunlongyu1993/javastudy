package com.testfan.javastudy.Day0706.Demo02;

/**
 * @author 孙珑瑜
 * @version 210712
 * 使用Lambd 方法优化日志案例
 * Lambd 特点：延迟执行
 * Lambda的使用前提：必须存在函数式接口
 */
public class Demo02Lambda {

    public static void show(int level,MessageBuilder md){
        if (level==1){
            System.out.println(md.builderMessage());
        }
    }

    public static void main(String[] args) {
        String msg1= "hello";
        String msg2= "world";
        String msg3= "java";

        show(2,()->{
         return msg1+msg2+msg3;
        });
    }

}
