package com.dubbo.dubbotest.lotterytest;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.testfan.MavenStudy.apistudy.dubbostudy.Serviceinit;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 孙珑瑜
 * @version 20210127
 */
public class DubboTests {
    String url = "dubbo://192.168.23.135:20880";
    String interfaceName = "/cn.testfan.dubbo.service.MarketService";
    String version = "1.0";

    @Test(description = "抽奖正确的接口")
    public void test01_lottery(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        //参数
        String[] prams = {"java.lang.Integer","java.lang.Integer"};
        //参数值{活动id，用户id}
        Object[] pramsvalue={1,1};
        Object response = service.$invoke("lottery", prams, pramsvalue);
        System.out.println(response.toString());
        //{code=0, data={createTime=Fri Dec 20 16:28:48 CST 2019, price=9888.0, name=iPhone 11, description=全网通黑色128G, id=1, stock=99990, type=1, class=cn.testfan.dubbo.model.Award, expirationDate=Sat Oct 31 16:28:39 CST 2020}, success=true, message=success, class=cn.testfan.dubbo.model.MarketResult}
        Assert.assertTrue(response.toString().contains("success=true"));
    }

    @Test(description = "抽奖-活动id不存在")
    public void test02_lottery(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        String[] prams = {"java.lang.Integer","java.lang.Integer"};
        Object[] pramsvalue={199,1};
        Object response = service.$invoke("lottery", prams, pramsvalue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains("message=活动不存在"));
    }
    @Test(description = "抽奖-活动类型不符")
    public void test03_lottery(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        String[] prams = {"java.lang.Integer","java.lang.Integer"};
        Object[] pramsvalue={2,1};
        Object response = service.$invoke("lottery", prams, pramsvalue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains("message=活动配置错误"));
    }
    @Test(description = "抽奖-活动已结束")
    public void test04_lottery(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        String[] prams = {"java.lang.Integer","java.lang.Integer"};
        Object[] pramsvalue={3,1};
        Object response = service.$invoke("lottery", prams, pramsvalue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains("message=活动已结束"));
    }
}
