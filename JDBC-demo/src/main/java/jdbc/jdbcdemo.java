package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 孙珑瑜
 * @version 20220727
 */
public class jdbcdemo {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://10.228.64.223:2399/zjy_test_240plus?useSSL=false";
        String username="zjy_test_240plus";
        String password="552819ab22424c76";
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql="select * from sys_org_level where deleted =0";
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        System.out.println(resultSet.getRow());
        stat.close();
        conn.close();
    }
}
