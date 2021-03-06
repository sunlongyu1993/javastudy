package com.testfan.MavenStudy.apistudy.HttpClient.Mtx;

import com.alibaba.fastjson.JSONPath;
import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;
import com.testfan.MavenStudy.apistudy.utils.DButil;
import com.testfan.MavenStudy.apistudy.utils.EncryptionUtil;
import com.testfan.MavenStudy.apistudy.utils.MyPropertisUtil;
import com.testfan.MavenStudy.apistudy.utils.RandomUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author 孙珑瑜
 * @version 20201231
 */
public class MtxShopTest_md5 {
    String ip;
    Map<Object,Object> param;
    Map<Object,Object> header;

    @BeforeClass
    public void init() throws Exception {
        ip ="http://192.168.23.135";
        param = new HashMap<>();
        header = new HashMap<>();
        header.put("X-Requested-With","XMLHttpRequest");
        String dburl = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxshop.jdbc.url");
        String dbuser = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxshop.jdbc.user");
        String dbpwd = MyPropertisUtil.getProperty("src/main/resources/db.properties", "mtxshop.jdbc.pwd");
        DButil.getconn(dburl,dbuser,dbpwd);
    }

    @Test//商城登录接口
    public void test001_reg() throws Exception {
//        Random random = new Random();
//        int i = random.nextInt(1000);
        Map<Object, Object> params = MyPropertisUtil.getAll("src/main/resources/mtxparams/mtxreg.properties");//从文件中读取参数

        //因为注册用户名不能重复，需要从参数文件中读取用户名，通过随机数的方式拼接形成新的用户名
        String rndStrAndNumberByLen = RandomUtil.getRndStrAndNumberByLen(8);

        String accounts = params.get("accounts").toString()+rndStrAndNumberByLen;//期望的用户
        String parampwd = params.get("pwd").toString();// 入参中的未加密的密码
        param.put("accounts",accounts);
        param.put("pwd",parampwd);
        param.put("type",params.get("type").toString());
        param.put("is_agree_agreement",params.get("is_agree_agreement").toString());
        //发送请求
        String res = MyHttpMethod.PostForm(ip + "/mtx/index.php?s=/index/user/reg.html", param, header);
        //断言接口响应值
        int statusCode = MyHttpMethod.getStatusCode();
        Assert.assertEquals(statusCode,200);
        //断言是否注册成功
        String msg = JsonPath.from(res).getString("msg");//方法一
        //方法二：String msg1 = JSONPath.extract(res, "$.msg").toString();
        Assert.assertEquals(msg,"注册成功");

        // 断言数据库生成的pwd字段加密是否正确
        //加密的业务：数据库中该用户的slat字段值+注册的密码，通过md5加密生成pwd字段
        String user_id = JSONPath.extract(res, "$.data.data.user_id").toString();//从返回值中取到生成的用户id
        String sql_data = "SELECT username,pwd,salt FROM `s_user` WHERE id ="+user_id;//根据生成的用户id，查询到生成的username,pwd,salt
        List<Map<String, Object>> maps = DButil.selectData(sql_data);//从数据库中获取到数据
        String act_username = maps.get(0).get("username").toString();// 数据库中取到的用户名
        String act_dbpwd = maps.get(0).get("pwd").toString();// 数据库中取到的用md5加密后的实际密码
        String act_salt = maps.get(0).get("salt").toString();
        String ext_pwd = EncryptionUtil.md5(act_salt + parampwd);//根据规则生成的期望密码
        System.out.println("加密后生成的pwd"+ext_pwd);
        Assert.assertEquals(act_dbpwd,ext_pwd);
        Assert.assertEquals(act_username,accounts);
    }
    @AfterClass
    public void afterclass() throws SQLException {
        DButil.close();
    }


}
