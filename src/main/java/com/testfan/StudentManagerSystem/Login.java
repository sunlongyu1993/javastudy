package com.testfan.StudentManagerSystem;

/**
 * @author 孙珑瑜
 * @version 20201105
 */
public class Login {
    // 判断登录是否成功
    public static boolean login(String name, String password){
        if(name.equalsIgnoreCase("sly")&& password.equalsIgnoreCase("123456")){
            System.out.println("登录成功");
            return true;
        }
        else {
            System.out.println("用户名或是密码错误");
            return false;
        }
    }
}
