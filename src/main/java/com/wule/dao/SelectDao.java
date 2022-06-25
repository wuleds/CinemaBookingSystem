package com.wule.dao;


import com.wule.pojo.FilmAllDate;
import com.wule.pojo.Seat;
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
    String seatNum_col = "seatNum";


    String benzhou = " datediff(now(),filmDate) <= 7 ";//计算电影离今天的天数。


    String select = " select ";
    String from = " from ";
    String where = " where ";
    String and=" and ";

    public SelectDao() throws SQLException {}

    /**
     * @作用 登录查询
     * @param userNum
     * @param userPassword
     * @return
     * @throws SQLException
     */
    public List<User> userLoginDao(String userNum, String userPassword) throws SQLException
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
    public boolean loginDao(String userNum) throws SQLException
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


    /**
     * @作用 查询本周所有电影,并返回。
     * @return List FilmAllDate
     * @throws SQLException
     */
    public List<FilmAllDate> getAllFilmDao() throws SQLException
    {
        List<FilmAllDate> list = new ArrayList<>();

        String sql=
                select
                     +cinemaNum_col+douhao+filmDate_col+douhao+eventNum_col+douhao+
                     event_table+dian+filmNum_col+douhao+
                     filmName_col+douhao+filmProfile_col+douhao+filmClass_col+douhao+
                     filmPrice_col+douhao+eventBeginTime_col+douhao+eventEndTime_col+

                from+event_table+douhao+film_table+
                where+event_table+dian+filmNum_col+dengyv+film_table+dian+filmNum_col+and+benzhou;

        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet == null)
        {
            return null;
        }

        while(resultSet.next())//将查询的结果存入对象
        {
            FilmAllDate filmAllDate = new FilmAllDate();

            filmAllDate.setCinemaNum(resultSet.getString("cinemaNum"));
            filmAllDate.setFilmDate(resultSet.getString("filmDate"));
            filmAllDate.setEventNum(resultSet.getString("eventNum"));
            filmAllDate.setFilmNum(resultSet.getString("event.filmNum"));
            filmAllDate.setEventBeginTime(resultSet.getString("eventBeginTime"));
            filmAllDate.setEventEndTime(resultSet.getString("eventEndTime"));

            filmAllDate.setFilmName(resultSet.getString("filmName"));
            filmAllDate.setFilmProfile(resultSet.getString("filmProfile"));
            filmAllDate.setFilmClass(resultSet.getString("filmClass"));
            filmAllDate.setFilmPrice(resultSet.getString("filmPrice"));
            list.add(filmAllDate);
            //将对象存入表
        }
        return list;
    }

    /**
     * @作用 根据用户号返回该用户所有数据
     * @param userNum
     * @return
     * @throws SQLException
     */
    public User userDataDao(String userNum) throws SQLException
    {
        User user = new User();
        String sql=
                select+all+from+user_table+where+userNum_col+dengyv+danyingh+userNum+danyingh+fenhao;

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
        {
            user.setUserNum(resultSet.getString("userNum"));
            user.setUserName(resultSet.getString("userName"));
            user.setUserPassword(resultSet.getString("userPassword"));
            user.setUserPower(resultSet.getString("userPower"));
            user.setUserIntegration(resultSet.getInt("userIntegration"));
        }
        return user;
    }

    /**
     * @作用 根据用户号查询票仓。
     * @param userNum 用户号
     * @return List
     */
    public List<Seat> getTicketDao(String userNum) throws SQLException
    {
        List<Seat> list = new ArrayList<>();
        String sql =
                select+all+
                        from+ticket_table+
                        where+userNum_col+dengyv+danyingh+userNum+danyingh+fenhao;

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
        {
            Seat seat = new Seat();
            seat.setUserNum(resultSet.getString("userNum"));
            seat.setCinemaNum(resultSet.getString("cinemaNum"));
            seat.setFilmDate(resultSet.getString("filmDate"));
            seat.setEventNum(resultSet.getString("eventNum"));
            seat.setSeatNum(resultSet.getString("seatNum"));
            seat.setFilmNum(resultSet.getString("filmNum"));

            list.add(seat);
        }
        return list;
    }

    /**
     * @作用 根据参数，返回座位信息
     * @param filmAllDate
     * @return List
     * @throws SQLException
     */
    public List<Seat> getSeatDao(FilmAllDate filmAllDate) throws SQLException
    {
        List<Seat> list = new ArrayList<>();
        String sql =
                select+all+
                        from+seat_table+
                        where+
                        cinemaNum_col+dengyv+danyingh+filmAllDate.getCinemaNum()+danyingh+and+
                        filmDate_col+dengyv+danyingh+filmAllDate.getFilmDate()+danyingh+and+
                        eventNum_col+dengyv+danyingh+filmAllDate.getEventNum()+danyingh+and+
                        filmNum_col+dengyv+danyingh+filmAllDate.getFilmNum()+danyingh+fenhao;

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
        {
            Seat seat = new Seat();
            seat.setCinemaNum(resultSet.getString("cinemaNum"));
            seat.setFilmDate(resultSet.getString("filmDate"));
            seat.setEventNum(resultSet.getString("eventNum"));
            seat.setUserNum(resultSet.getString("userNum"));
            seat.setSeatNum(resultSet.getString("seatNum"));
            list.add(seat);
        }
        return list;
    }


    /**
     * @作用 根据座位号和其他信息查询该座位是否有人；如果有人，则返回用户号。
     * @param filmAllDate 放映厅号、场次号等信息
     * @param seatNum 座位号
     * @return userNum
     */
    public String getSeadUserNumDao(FilmAllDate filmAllDate,String seatNum) throws SQLException
    {
        String userNum = null;

        String sql=select+userNum_col+
                from+seat_table+
                where+
                cinemaNum_col+dengyv+danyingh+filmAllDate.getCinemaNum()+danyingh+and+
                filmDate_col+dengyv+danyingh+filmAllDate.getFilmDate()+danyingh+and+
                eventNum_col+dengyv+danyingh+filmAllDate.getEventNum()+danyingh+and+
                seatNum_col+dengyv+danyingh+seatNum+danyingh+and+
                filmNum_col+dengyv+danyingh+filmAllDate.getFilmNum()+danyingh+
                fenhao;

        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next())
            userNum = resultSet.getString("userNum");

        if (userNum == null || userNum.length()<1)
            return null;

        return userNum;
    }


    /**
     * @作用 根据参数查询对应的电影信息。
     * @param filmName 电影名
     * @return List
     * @throws SQLException
     */
    public List<FilmAllDate> fromNameToFilmDao(String filmName) throws SQLException
    {
        List<FilmAllDate> list  = new ArrayList<>();

        String sql =
                select+all+
                        from+film_table+
                        where+filmName_col+dengyv+danyingh+filmName+danyingh+fenhao;
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet == null)
            return null;
        else
        {
            while(resultSet.next())
            {
                FilmAllDate filmAllDate = new FilmAllDate();
                filmAllDate.setFilmNum(resultSet.getString("filmNum"));
                filmAllDate.setFilmName(resultSet.getString("filmName"));
                filmAllDate.setFilmProfile(resultSet.getString("filmProfile"));
                filmAllDate.setFilmClass(resultSet.getString("filmClass"));
                filmAllDate.setFilmPrice(resultSet.getString("filmPrice"));
                list.add(filmAllDate);
            }
        }
        return list;

    }
    /**
     * @作用 根据参数查询对应的电影信息。
     * @param Class 电影分类
     * @return List
     * @throws SQLException
     */
    public List<FilmAllDate> fromClassToFilmDateDao(String Class) throws SQLException
    {
        List<FilmAllDate> list = new ArrayList<>();
        String sql =
                select+all+
                from+film_table+
                where+filmClass_col+dengyv+danyingh+Class+danyingh+fenhao;
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet == null)
            return null;
        else
        {
            while(resultSet.next())
            {
                FilmAllDate filmAllDate = new FilmAllDate();
                filmAllDate.setFilmNum(resultSet.getString("filmNum"));
                filmAllDate.setFilmName(resultSet.getString("filmName"));
                filmAllDate.setFilmProfile(resultSet.getString("filmProfile"));
                filmAllDate.setFilmClass(resultSet.getString("filmClass"));
                filmAllDate.setFilmPrice(resultSet.getString("filmPrice"));
                list.add(filmAllDate);
            }
        }
        return list;
    }




//    public static void main(String[] args) throws SQLException
//    {
//        SelectDao selectDao = new SelectDao();
//
//        List<Seat> list = selectDao.getTicketDao("1");
//        System.out.println(list);
//    }
}
