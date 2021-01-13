package com.testfan.MavenStudy.apistudy.utils;

import java.sql.*;

/**
 * @author 孙珑瑜
 * @version 20210113
 */
public class DButil {
    //连接数据库
    public static void main(String[] args) throws SQLException {
        String url ="jdbc:mysql://192.168.23.129:3306/crm?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";
        String dbusername = "root";
        String dbpwd = "123456";
        String sql = "SELECT * FROM `72crm_crm_customer`";

        Connection connection = DriverManager.getConnection(url, dbusername, dbpwd);//连接数据库，返回连接对象
//        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);//预处理sql语句对象
        ResultSet resultSet = preparedStatement.executeQuery();//执行查询语句
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();// 获取结果的总列数
        System.out.println(columnCount);
        connection.close();//关闭连接


    }
}
