package com.SalaryManagement.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;
    //初始化数据库池
    static{
        try{
            Properties properties = new Properties();
            properties.setProperty("driverClassName","com.mysql.cj.jdbc.Driver");
            properties.setProperty("url","jdbc:mysql://localhost:3306/salary_management_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone =Asia/Shanghai");
            properties.setProperty("username","root");
            properties.setProperty("password","228888");
            properties.setProperty("initialSize","5");
            properties.setProperty("maxActive","10");
            properties.setProperty("maxWait","3000");
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接的方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //释放资源的方法
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //重载释放资源
    public static void close(Statement statement, Connection connection){
        close(null,statement,connection);
    }
    //获取连接池的方法

    public static DataSource getDataSource() {
        return ds;
    }
}
