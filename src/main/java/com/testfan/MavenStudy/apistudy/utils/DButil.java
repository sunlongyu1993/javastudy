package com.testfan.MavenStudy.apistudy.utils;

import com.testfan.MavenStudy.apistudy.common.MyHttpMethod;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Logger.*;

/**
 * @author 孙珑瑜
 * @version 20210113
 */
public class DButil {
    private static Connection conn;
    private static Logger logger= Logger.getLogger(String.valueOf(DButil.class));


    /**
     * 获取数据库连接对象
     * @param url
     * @param dbusername
     * @param dbpwd
     * @throws SQLException
     */
    public static void getconn(String url,String dbusername, String dbpwd) throws SQLException {
        conn = DriverManager.getConnection(url, dbusername, dbpwd);//连接数据库，返回连接对象
    }

    /**
     * 查询方法
     * @param sql
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> selectData(String sql) throws SQLException {
        List<Map<String,Object >> result = new ArrayList<Map<String,Object >>();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);//预处理sql语句对象
        ResultSet resultSet = preparedStatement.executeQuery();//用来查询数据库信息
        ResultSetMetaData metaData = resultSet.getMetaData();//metaData 是表单类的数据,可以获取列数，以及列的名称
        int columnCount = metaData.getColumnCount();// 获取结果的总列数
        while (resultSet.next()){// 如果有下一行，则一列列的读取
             Map<String,Object > linemap = new HashMap<>();
            for (int i = 1; i <=columnCount; i++) {
                Object dbvaule = resultSet.getObject(i);//读这一行中的某一列的值
                String columnLabel = metaData.getColumnLabel(i);// 获取列的名称
                if(dbvaule ==null){
                    dbvaule ="";
                }

//                System.out.println(columnLabel+"="+dbvaule.toString());
                linemap.put(columnLabel,dbvaule);
            }
//            System.out.println("=====================================");
            result.add(linemap);
        }
        return result;
    }

    /**
     * Updata 可以执行新增、更新以及删除3中sql语句
     * @param sql
     * @return
     */
    public static int updataData(String sql)  {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeQuery(sql);//用来查询数据库信息
            int updateCount = stmt.getUpdateCount();
            return updateCount;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return 0;
    }

    /**
     * close关闭连接池
     * @throws SQLException
     */
    public static void close() throws SQLException {
        conn.close();
    }




    public static void main(String[] args) throws SQLException {
        String url ="jdbc:mysql://192.168.23.129:3306/crm?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";
        String dbusername = "root";
        String dbpwd = "123456";
        String sql = "SELECT * FROM `72crm_crm_customer`";
        List<Map<String, Object>> maps = selectData(sql);
        for (Map<String, Object> q:maps
             ) {
            System.out.println(q);
        }


//        Connection connection = DriverManager.getConnection(url, dbusername, dbpwd);//连接数据库，返回连接对象
////        Statement statement = connection.createStatement();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);//预处理sql语句对象
//
//        ResultSet resultSet = preparedStatement.executeQuery();//执行查询语句
//        //metaData 是表单类的数据,可以获取列数，以及列的名称
//        // customer_id =1,customer_name = hadaf
//        ResultSetMetaData metaData = resultSet.getMetaData();
//
//        int columnCount = metaData.getColumnCount();// 获取结果的总列数
//        System.out.println(columnCount);
//        // 用循环遍历输出得到的数据
//        while (resultSet.next()){// 如果有下一行，则一列列的读取
//            for (int i = 1; i <columnCount ; i++) {
//                Object object = resultSet.getObject(i);//读这一行中的某一列的值
//                // 获取列的名称
//                String columnLabel = metaData.getColumnLabel(i);
//                if (object == null){
//                    object = "";
//                }
//                System.out.println(columnLabel+"="+object.toString());
//            }
//            System.out.println("================================");
//        }

//        conn.close();//关闭连接
        getconn(url,dbusername,dbpwd);
        List<Map<String, Object>> data = selectData(sql);
        for (Map<String,Object>  line:data) {
//            System.out.println(line);// 將每一行都打印出来
            // map 对象的遍历
            Set<Map.Entry<String, Object>> entries = line.entrySet();
            for (Map.Entry<String, Object> s:entries) {
                System.out.println(s.getKey()+"="+s.getValue());
            }


        }
        Object create_user_id = data.get(0).get("create_");
        System.out.println(create_user_id.toString());



    }
}
