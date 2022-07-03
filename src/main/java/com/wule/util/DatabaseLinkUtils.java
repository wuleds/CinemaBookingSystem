package com.wule.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//创建于2022/6/20 22:50
//连接数据库工具类，去除重复连接数据库的操作。
public class DatabaseLinkUtils
{

    private static final Connection conn;
    private static final Statement stmt;

    static  //静态代码块，只执行一次。
    {
        final String Driver ="com.mysql.cj.jdbc.Driver" ;
        final String url = "jdbc:mysql://127.0.0.1:3306/javadata?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        final String user = "root";
        final String password = "123456";

        try
        {
            Class.forName(Driver) ; // 加载驱动程序
            conn = DriverManager.getConnection(url, user, password);//连接数据库
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("数据库连接失败");
            throw new RuntimeException(e);
        }
    }

    /**
     * @作用 自动连接数据库的工具类
     * @return Statement
     */
    public static Statement getStatement()
    {
        return stmt;// 返回Statement对象
    }

}
