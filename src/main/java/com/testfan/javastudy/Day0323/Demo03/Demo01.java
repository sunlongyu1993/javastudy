package com.testfan.javastudy.Day0323.Demo03;

import java.util.Scanner;

/**
 * @author 孙珑瑜
 * @version 20210324
 */
public class Demo01 {
    static String[] arr = {"张三","李四","王五"};
    public static void main(String[] args) /*throws RegisterException*/ {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要注册的用户名：");
        String username = sc.next();
        checkUsername(username);

    }
    public static void checkUsername(String username) /*throws RegisterException*/ {
        for (String name : arr) {
            if(name.equals(username)){
//                throw new RegisterException("用户已经存在，请重新输入新的用户名");

                try {
                    throw new RegisterException("用户已经存在，请重新输入新的用户名");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        System.out.println("恭喜你，注册成功");

    }

}
