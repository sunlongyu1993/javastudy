package com.testfan.MavenStudy.apistudy.dubbostudy;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import org.testng.Reporter;

import java.util.logging.Logger;

/**
 * @author 孙珑瑜
 * @version 20210127
 */
public class Serviceinit {
    private static Logger logger= Logger.getLogger(String.valueOf(MyHttpMethod.class));

    public static GenericService getService(String url, String interfaceName, String version){
        ReferenceConfig<GenericService> refer=new ReferenceConfig<>();//引用配置
        refer.setApplication(new ApplicationConfig("test"));//设置应用
        refer.setGeneric(true);//是否是一个通用的服务
        refer.setTimeout(20000);//超时时间2万毫秒
        refer.setVersion(version);//版本
        logger.info("传入的版本是："+version);
        Reporter.log("传入的版本是："+version);
        refer.setUrl(url);//要连接的url,注册中心的地址
        logger.info("传入的url是："+url);
        Reporter.log("传入的url是："+url);
        refer.setInterface(interfaceName);//要连接的服务是哪一个
        logger.info("传入的setInterface是："+interfaceName);
        Reporter.log("传入的setInterface是："+interfaceName);


        ReferenceConfigCache cache =ReferenceConfigCache.getCache();//配置生成一个缓存对象
        GenericService service = cache.get(refer);//将配置添加到缓存对象中,生成一个通用服务接口的对象，这个通用服务对象可以调用接口
        return service;
        //相当于在黑窗口中连接dubbo服务  telnet ip 端口
    }
}
