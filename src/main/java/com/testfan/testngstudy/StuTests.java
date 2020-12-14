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
    @DataProvider
    public  Object[][] getloginData(){
        Object[][] obj ={};
        return null;
    }

    @Test
    public void login(){
        boolean flag = Login.login("admin", "123456");
        Assert.assertTrue(flag);
    }
}
