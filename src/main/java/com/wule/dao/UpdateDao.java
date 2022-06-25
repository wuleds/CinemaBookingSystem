package com.wule.dao;

import com.wule.pojo.FilmAllDate;
import com.wule.util.DatabaseLinkUtils;

import java.sql.SQLException;
import java.sql.Statement;

//创建于2022/6/24 23:15
public class UpdateDao
{
    Statement stmt = DatabaseLinkUtils.getStatement();

    String user_table = " user ";
    String seat_table = " seat ";
    String event_table = " event ";
    String film_table = " film ";
    String cinema_table = " cinema ";
    String ticket_table = " ticket ";

    String dian =       ".";
    String danyingh =    "'";
    String space =      " ";
    String fenhao =      ";";
    String douhao =      ",";
    String dengyv =      " = ";
    String all =         "*";

    String userNum_col = "userNum";
    String userPassword_col = "userPassword";

    String cinemaNum_col = "cinemaNum";//放映厅编号
    String filmDate_col = "filmDate";//播放日期
    String eventNum_col = "eventNum";//场次号
    String eventBeginTime_col = "eventBeginTime";//场次开始时间
    String eventEndTime_col = "eventEndTime";//场次结束时间

    String filmNum_col = "filmNum";//电影号
    String filmName_col = "filmName";//电影名
    String filmProfile_col = "filmProfile";//电影简介
    String filmClass_col = "filmClass";//电影分类
    String filmPrice_col = "filmPrice";//电影价格
    String seatNum_col = " seatNum";

    String update = " update ";
    String from = " from ";
    String where = " where ";
    String and=" and ";
    String set = " set ";

    public UpdateDao() throws SQLException {}

    /**
     * @作用 根据参数，给用户座位。
     * @param filmAllDate
     * @param userNum
     * @throws SQLException
     */
    public void addUserToSeatDao(FilmAllDate filmAllDate, String seatNum, String userNum) throws SQLException
    {
        String sql = update+seat_table+set+userNum_col+dengyv+danyingh+userNum+danyingh+
                where+cinemaNum_col+dengyv+danyingh+filmAllDate.getCinemaNum()+danyingh+and+
                filmDate_col+dengyv+danyingh+filmAllDate.getFilmDate()+danyingh+and+
                eventNum_col+dengyv+danyingh+filmAllDate.getEventNum()+danyingh+and+
                seatNum_col+dengyv+danyingh+seatNum+danyingh+and+
                filmNum_col+dengyv+danyingh+filmAllDate.getFilmNum()+danyingh+fenhao;
        stmt.executeUpdate(sql);
    }

//    public static void main(String[] args) throws SQLException
//    {
//        UpdateDao updateDao = new UpdateDao();
//        updateDao.addUserToSeatDao(new FilmAllDate("1","1","2022-6-21","2"),"1","1");
//    }
}
