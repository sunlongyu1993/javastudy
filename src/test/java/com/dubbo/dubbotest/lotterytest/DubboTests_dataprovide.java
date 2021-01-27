package com.dubbo.dubbotest.lotterytest;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.testfan.MavenStudy.apistudy.dubbostudy.Serviceinit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 封装用例——数据驱动
 * @author 孙珑瑜
 * @version 20210127
 */
public class DubboTests_dataprovide {
    String url = "dubbo://192.168.23.135:20880";
    String interfaceName = "/cn.testfan.dubbo.service.MarketService";
    String version = "1.0";

    @DataProvider
    public Object[][] getlotteryData(){
        Object[][] obj ={
                {"抽奖——正确的接口",1,1,"success=true"},
                {"抽奖-活动id不存在",199,1,"message=活动不存在"},
                {"抽奖——活动类型不符",2,1,"message=活动配置错误"},
                {"抽奖——活动已结束",3,1,"message=活动已结束"},
                {"抽奖——用户不存在",1,7,"message=该用户无积分"}
        };
        return obj;
    }

    @Test(dataProvider = "getlotteryData")
    public void test01_lottery(String casename,int activityid,int userid,String assertvalue){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        //参数值{活动id，用户id}
        String[] prams = {"java.lang.Integer","java.lang.Integer"};
        Object[] pramsvalue={activityid,userid};
        //调用接口
        Object response = service.$invoke("lottery", prams, pramsvalue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains(assertvalue));
    }

}
