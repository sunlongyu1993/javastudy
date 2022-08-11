package jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author 孙珑瑜
 * @version 20220727
 * JDBC api详解-ResultSet,执行DQL语句（查询语句）
 */
public class jdbcdemo_ResultSet {
    @Test
    public void ResultSetTest() throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");//1、注册驱动，可以省略
        //2、获取连接，注意，如果获取的是本地mysql并且端口是3306，可以简化书写
        String url="jdbc:mysql://10.228.64.223:2399/zjy_test_240plus?useSSL=false";
        String username="zjy_test_240plus";
        String password="552819ab22424c76";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3、定义sql
        String sql="select * from sys_org_level where deleted =0";
        //4、获取执行SQL的对象Statement
        Statement stat = conn.createStatement();
        //5、执行SQL，
        ResultSet rs = stat.executeQuery(sql);
        //6、处理结果
        while (rs.next()){
            int level_Id = rs.getInt(1);
            String level_desc = rs.getString(2);
            Date addtime = rs.getDate(3);
            Date updatetime = rs.getDate(4);
            int del = rs.getInt(5);
            System.out.println(level_Id);
            System.out.println(level_desc);
            System.out.println(addtime);
            System.out.println(updatetime);
            System.out.println(del);
            System.out.println("=========================");

        }

        //7、释放资源
        stat.close();
        conn.close();
    }
}
