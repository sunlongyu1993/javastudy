package com.dubbo.dubbotest.exchangetest;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.testfan.MavenStudy.apistudy.dubbostudy.Serviceinit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙珑瑜
 * @version 20210127
 */
public class exchangetests {
    String url = "dubbo://192.168.23.135:20880";
    String interfaceName = "/cn.testfan.dubbo.service.MarketService";
    String version = "1.0";

    @Test(description = "抽奖正确的接口")
    public void test01_lottery(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        //参数类型
        String[]  prams = {"cn.testfan.dubbo.model.ExchangeRequest"};
        //参数值——对象对应的所有的值
        // {"class":"cn.testfan.dubbo.model.ExchangeRequest","userId":"10001","activityId":"1","awardId":"1","exchangeNum":"1"}
        Map<String,Object> pramsjson = new HashMap<>();
        Object[] pramvalue ={pramsjson};
//        pramsjson.put("userId",);
//        pramsjson.put("activityId",);
//        pramsjson.put("awardId",);
//        pramsjson.put("exchangeNum",);
        Object response = service.$invoke(url, prams, pramvalue);
        Assert.assertTrue(response.toString().contains("success=true"));
    }

}
