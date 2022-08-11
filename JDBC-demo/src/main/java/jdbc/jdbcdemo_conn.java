package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 孙珑瑜
 * @version 20220727
 */
public class jdbcdemo_conn {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");//1、注册驱动，可以省略
        //2、获取连接，注意，如果获取的是本地mysql并且端口是3306，可以简化书写
        String url="jdbc:mysql://10.228.64.223:2399/zjy_test_240plus?useSSL=false";
        //String url="jdbc:mysql:///zjy_test_240plus?useSSL=false";-简化书写
        String username="zjy_test_240plus";
        String password="552819ab22424c76";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3、定义sql
        String sql="select * from sys_org_level where deleted =0";
        String sql2="select * from sys_org_level where deleted =0";
        //4、获取执行SQL的对象Statement
        Statement stat = conn.createStatement();
        try { //开启事物
            conn.setAutoCommit(false);
            //5、执行SQL，
            ResultSet resultSet = stat.executeQuery(sql);
            //6、处理结果
            System.out.println(resultSet.getRow());
            ResultSet resultSet2 = stat.executeQuery(sql2);
            System.out.println(resultSet2.getRow());
            //提交事物
            conn.commit();
        }catch (Exception throwables){
            conn.rollback();//有异常，在需要回滚事物
        }




        //7、释放资源
        stat.close();
        conn.close();
    }
}
