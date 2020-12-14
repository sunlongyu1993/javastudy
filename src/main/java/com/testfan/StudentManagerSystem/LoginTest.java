package com.testfan.StudentManagerSystem;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20201113a
 */
public class LoginTest {
    // 正确用例
    @Test(groups = "login")
    public void loginCorrect(){
        boolean flag = Login.login("sly", "123456");
        Assert.assertTrue(flag);
        Assert.fail("强制失败");
    }
    // 用户名错误
    @Test(groups = "login")
    public void loginUsernameError(){
        boolean flag = Login.login("sly1", "123456");
        Assert.assertFalse(flag);
    }
    //密码错误
    @Test(groups = "login")
    public void loginPwdError(){
        boolean flag = Login.login("sly", "12345");
        Assert.assertFalse(flag);
    }
    // 判断两个值是否相等
    @Test(groups = "add")
    public void add(){
        int a =10;
        int b =20;
        int sum =a+b;
        Assert.assertEquals(sum,30);
//        Assert.assertEquals(sum,31);
    }
    @Test(dependsOnMethods = "loginCorrect")
//    @Test
    public void addStu(){
        StuDB.add("sly1",18810677210L);
        Student student = StuDB.stuMap.get(18810677210L);
        Assert.assertNotNull(student);
    }

}
