package com.wule.dao;

import com.wule.pojo.FilmAllDate;
import com.wule.pojo.User;
import com.wule.util.DatabaseLinkUtils;

import java.sql.SQLException;
import java.sql.Statement;

//用户注册
//创建于2022/6/21 14:36
public class InsertIntoDao
{
    String insert = " insert into ";
    String values = " values ";
    String update = " update ";
    String set = " set ";
    String from = " from ";
    String where = " where ";
    String and=" and ";

    String user_table = " user";
    String seat_table = " seat ";
    String event_table = " event ";
    String film_table = " film ";
    String cinema_table = " cinema ";
    String ticket_table = " ticket ";

    String dian =      ".";
    String danyingh = "'";
    String space =     " ";
    String fenhao =    ";";
    String douhao =    ",";
    String dengyv =   " = ";
    String all =       " * ";
    String add = " + ";

    String userNum_col = "userNum";
    String userPassword_col = "userPassword";
    String userIntegration_col = "userIntegration";

    String cinemaNum_col = "cinemaNum";//放映厅编号
    String filmDate_col = "filmDate";//播放日期
    String eventNum_col = "eventNum";//场次号
    String eventBeginTime_col = "eventBeginTime";//场次开始时间
    String eventEndTime_col = "eventEndTime";//场次结束时间
    String seatNum_col = "seatNum";

    String filmNum_col = "filmNum";//电影号
    String filmName_col = "filmName";//电影名
    String filmProfile_col = "filmProfile";//电影简介
    String filmClass_col = "filmClass";//电影分类
    String filmPrice_col = "filmPrice";//电影价格

    Statement stmt = DatabaseLinkUtils.getStatement();

    public InsertIntoDao() throws SQLException {
    }

    /**
     * @作用 对接数据库，增加数据,没有任何判断。
     * @param user
     * @throws SQLException
     */
    public void addUserDao(User user ) throws SQLException
    {


        String sql=
                insert+user_table+
                        values+"("+danyingh+user.getUserNum()+danyingh+douhao+
                        danyingh+user.getUserName()+danyingh +douhao+
                        danyingh+user.getUserPassword()+danyingh+douhao+
                        danyingh+user.getUserPower()+danyingh+douhao+
                        user.getUserIntegration()+");";
        stmt.executeUpdate(sql);
    }


    /**
     * @作用 给用户加积分，票仓加票。
     * @param userNum ,
     * @param cinemaNum ,
     * @param filmDate ,
     * @param eventNum ,
     * @param filmNum ,
     * @param filmPrice ,
     * @throws SQLException ,
     */
    public void byTicketDao(String userNum,String cinemaNum,String filmDate,String eventNum,
                            String filmNum,int filmPrice) throws SQLException
    {

        String addUserIntegration = update+user_table+
                set+userIntegration_col+dengyv+userIntegration_col+add+filmPrice+
                where+userNum_col +dengyv + danyingh+userNum+danyingh+fenhao;
        //给用户加积分。
        String sql = insert+ticket_table+
                values+"("+danyingh+userNum+danyingh+douhao+
                danyingh+cinemaNum+danyingh+douhao+
                danyingh+filmDate+danyingh+douhao+
                danyingh+eventNum+danyingh+douhao+
                danyingh+filmNum+danyingh+")"+fenhao;
        //向用户票仓添加票

        stmt.executeUpdate(addUserIntegration);
        stmt.executeUpdate(sql);
    }


    /**
     * @作用 添加座位
     * @param filmAllDate
     * @param seatNum
     * @throws SQLException
     */
    public void addSeatDao(FilmAllDate filmAllDate, int seatNum) throws SQLException {
        String sql=
                insert+seat_table+"("+cinemaNum_col+douhao+filmDate_col+douhao+eventNum_col+douhao+filmNum_col+douhao+seatNum_col+douhao+userNum_col+")"+
                        values+
                        "("+danyingh+filmAllDate.getCinemaNum()+danyingh+douhao+
                        danyingh+filmAllDate.getFilmDate()+danyingh+douhao+
                        danyingh+filmAllDate.getEventNum()+danyingh+douhao+
                        danyingh+filmAllDate.getFilmNum()+danyingh+douhao+
                        danyingh+seatNum+danyingh+douhao+
                        null+")"+fenhao;
        stmt.executeUpdate(sql);
    }


//    public static void main(String[] args) throws SQLException
//    {
//        InsertIntoDao insertIntoService = new InsertIntoDao();
//        insertIntoService.addSeat(new FilmAllDate("1","1","2022-6-21","2"),1);
//    }
}
