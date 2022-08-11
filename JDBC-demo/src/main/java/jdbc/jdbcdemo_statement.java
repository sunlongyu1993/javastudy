package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 孙珑瑜
 * @version 20220727
 * DDL
 */
public class jdbcdemo_statement {
    @Test
    public void test1() throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");//1、注册驱动，可以省略
        //2、获取连接，注意，如果获取的是本地mysql并且端口是3306，可以简化书写
        String url="jdbc:mysql://10.228.64.223:2399/zjy_test_240plus?useSSL=false";
        String username="zjy_test_240plus";
        String password="552819ab22424c76";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3、定义sql
        String sql="update * set money =1 where deleted =0";
        //4、获取执行SQL的对象Statement
        Statement stat = conn.createStatement();
        //5、执行SQL，
        int i = stat.executeUpdate(sql);
        //6、处理结果
        System.out.println(i);
        //7、释放资源
        stat.close();
        conn.close();
    }
}
