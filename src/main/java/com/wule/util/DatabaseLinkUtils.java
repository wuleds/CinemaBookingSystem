package com.wule.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//创建于2022/6/20 22:50
//连接数据库工具类，去除重复连接数据库的操作。
public class DatabaseLinkUtils
{

    private static Connection conn; // 数据库连接
    private static Statement stmt; // 数据库操作

    static
    {
        final String Driver ="com.mysql.cj.jdbc.Driver" ;
        final String url = "jdbc:mysql://127.0.0.1:3306/javadata?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        final String user = "root";
        final String password = "123456";

        try
        {
            Class.forName(Driver) ; // 加载驱动程序
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }


    public static Statement getStatement() throws SQLException
    {
        return stmt;// 实例化Statement对象
    }

}
