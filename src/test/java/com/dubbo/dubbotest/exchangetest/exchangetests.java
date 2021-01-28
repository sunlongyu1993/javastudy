package com.dubbo.dubbotest.exchangetest;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.testfan.MavenStudy.apistudy.dubbostudy.Serviceinit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
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

    @Test(description = "积分兑换——正确的接口")
    public void test01_exchange(){
        //需要有连接对象
        GenericService service = Serviceinit.getService(url, interfaceName, version);
        //参数类型
        String[]  prams = {"cn.testfan.dubbo.model.ExchangeRequest"};
        //参数值——对象对应的所有的值
        // {"class":"cn.testfan.dubbo.model.ExchangeRequest","userId":"10001","activityId":"1","awardId":"1","exchangeNum":"1"}
        Map<String,Object> pramsjson = new HashMap<>();
        Object[] pramvalue ={pramsjson};
        pramsjson.put("userId",1);
        pramsjson.put("activityId",2);
        pramsjson.put("awardId",4);
        pramsjson.put("exchangeNum",1);
        Object response = service.$invoke("exchange", prams, pramvalue);

        //解析dubbo返回值——转化为map 对象
        Map<String,Object> resmaps = (Map<String, Object>) response;
        Object message = resmaps.get("message");
        System.out.println(message.toString());
        //解析dubbo返回值——如果路径过深，可以转化为json格式

        System.out.println(response.toString());
        //{code=0, data={createTime=Wed Dec 25 13:58:34 CST 2019, price=68.0, name=金龙鱼花生油, description=金龙鱼, id=4, stock=99998, type=1, class=cn.testfan.dubbo.model.Award, expirationDate=Sat Feb 29 13:58:28 CST 2020}, success=true, message=success, class=cn.testfan.dubbo.model.MarketResult}
        Assert.assertTrue(response.toString().contains("success=true"));
    }
    @DataProvider
    public Object[][] getExchangeData(){
        Object[][] obj ={
                {"积分兑换——正确的接口",       "1","2","4","1","success=true"},
                {"积分兑换——用户id不存在",     "10","2","4","1","message=该用户无积分"},
                {"积分兑换——用户积分不足",     "3","2","4","1","message=该用户积分不足"},
                {"积分兑换——活动id不存在","1","10","4","1","message=活动不存在"},
                {"积分兑换——活动已结束",       "1","4","4","1","message=活动已结束"},
                {"积分兑换——奖品id不存在",     "1","2","6","1","message=找不到奖品对应的活动"},
                {"积分兑换——奖品数量超出限制",     "1","2","4","3","message=找不到奖品对应的活动"}
        };
        return obj;
    }
    //用数据驱动进行测试
    @Test(dataProvider="getExchangeData")
    public void test02_exchange(String casename,String userid,String activityid,String awardid,String exchangeNum,String assertvalue){
        GenericService service= Serviceinit.getService(url,interfaceName,version);
        //参数类型
        String[]  prams = {"cn.testfan.dubbo.model.ExchangeRequest"};
        Map<String,Object> pramsjson = new HashMap<>();
        Object[] pramvalue ={pramsjson};
        pramsjson.put("userId",userid);
        pramsjson.put("activityId",activityid);
        pramsjson.put("awardId",awardid);
        pramsjson.put("exchangeNum",exchangeNum);

        Object response = service.$invoke("exchange", prams, pramvalue);
        System.out.println(response.toString());
        Assert.assertTrue(response.toString().contains(assertvalue));
    }


}
