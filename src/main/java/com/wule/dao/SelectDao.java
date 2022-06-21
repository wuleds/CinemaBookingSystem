package com.wule.dao;


import com.wule.pojo.User;
import com.wule.util.DatabaseLinkUtils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//创建于2022/6/21 10:35
public class SelectDao
{
    Statement stmt = DatabaseLinkUtils.getStatement();
    String user_table = " user";
    String seat_table = " seat";
    String event_table = " event";

    String danyingh = "'";
    String space = " ";
    String fenhao = ";";
    String douhao = ",";
    String dengyv = " = ";
    String all = " * ";

    String userNum_col = "userNum";
    String userPassword_col = "userPassword";


    String select = " select ";
    String from = " from ";
    String where = " where ";
    String and=" and ";

    public SelectDao() throws SQLException {
    }

    /**
     * @作用 登录查询
     * @param userNum
     * @param userPassword
     * @return
     * @throws SQLException
     */
    public List<User> userLogin(String userNum,String userPassword) throws SQLException
    {

        List<User> list = new ArrayList<>();
        User user = new User();
        String sql =
                select+userNum_col+douhao+userPassword_col
                + from+user_table+
                where+userNum_col+dengyv+danyingh+userNum+danyingh+and+userPassword_col+dengyv+danyingh+userPassword+danyingh+fenhao;


        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())// 指针向下移动
        {
            String num = resultSet.getString("userNum"); // 取得id内容
            String password = resultSet.getString("userPassword");// 取得name内容
            user.setUserNum(num);
            user.setUserPassword(password);
        }
        if(user.getUserNum()==null)
            return null;
        else {
            list.add(user);
            return list;
        }
    }


    /**
     * @作用 查询该用户号是否存在。返回true代表该用户号不存在，可以创建。
     * @param userNum
     * @return
     * @throws SQLException
     */
    public boolean login(String userNum) throws SQLException
    {
        String sql =
                select+userNum_col
                        + from+user_table+
                        where+userNum_col+dengyv+danyingh+userNum+danyingh+fenhao;


        ResultSet resultSet = stmt.executeQuery(sql);

        String num = null;
        while(resultSet.next())// 指针向下移动
        {
             num = resultSet.getString("userNum"); // 取得id内容
        }
        return num == null;
    }


    public List<>
    /*public static void main(String[] args) throws SQLException
    {
        SelectDao selectDao = new SelectDao();
        selectDao.login("123");
    }*/
}
