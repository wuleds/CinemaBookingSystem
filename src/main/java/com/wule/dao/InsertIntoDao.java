package com.wule.dao;

import com.wule.pojo.User;
import com.wule.service.InsertIntoService;
import com.wule.util.DatabaseLinkUtils;

import java.sql.SQLException;
import java.sql.Statement;

//用户注册
//创建于2022/6/21 14:36
public class InsertIntoDao
{
    /**
     * @作用 对接数据库，增加数据,没有任何判断。
     * @param user
     * @throws SQLException
     */
    public void addUserDao(User user ) throws SQLException
    {
        Statement stmt = DatabaseLinkUtils.getStatement();
        String insert = " insert into ";
        String user_table = " user";
        String values = " values ";
        String douhao = ",";
        String danyingh = "'";

        String sql=
                insert+user_table+
                        values+"("+danyingh+user.getUserNum()+danyingh+douhao+
                        danyingh+user.getUserName()+danyingh +douhao+
                        danyingh+user.getUserPassword()+danyingh+douhao+
                        danyingh+user.getUserPower()+danyingh+douhao+
                        user.getUserIntegration()+");";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

//    public static void main(String[] args) throws SQLException {
//        InsertIntoDao insertIntoService = new InsertIntoDao();
//        insertIntoService.addUserDao(new User("123","wule","fjjfj","jfdsf",0));
//    }
}
