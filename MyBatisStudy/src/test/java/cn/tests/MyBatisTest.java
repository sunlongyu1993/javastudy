package cn.tests;

import cn.mapper.UserMapper;
import cn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * @author 孙珑瑜
 * @version 20220817
 */
public class MyBatisTest {
    Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws Exception {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test1(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserInfo(1001091);
            //logger.info(user.toString());
            //System.out.println(user);
        }catch (Exception e){
        //logger.error("日志输出错误信息");
        }
    }
}
