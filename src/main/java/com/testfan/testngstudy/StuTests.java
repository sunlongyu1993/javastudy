package com.testfan.testngstudy;

import com.testfan.StudentManagerSystem.Login;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20201212
 */
public class StuTests {
    //三条用例数据
    //正确登录，"admin","123456",true;
    //用戶名不正确：”admin234“,"123456",false;
    //密码不正确：“admin”,"111111111111111".false;

    // 数据驱动或者参数化的方式来执行测试
    @DataProvider// 该注解所标注的方法是用来提供测试数据的，方法的返回值必须是一个object 的二维数组
    public  Object[][] getloginData(){
        Object[][] obj ={
                {"正确登录","sly","123456",true},
                {"用户名不正确","sly123","123456",false},
                {"密码错误","sly","123456666",false}
        };
        return obj;
    }

    @Test(dataProvider = "getloginData")
    public void login(String casename,String username,String pwd,boolean expect){
        boolean flag = Login.login(username, pwd);
//        Assert.assertTrue(flag);
        Assert.assertEquals(flag,expect);
    }
}
