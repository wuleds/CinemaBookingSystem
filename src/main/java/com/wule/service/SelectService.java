package com.wule.service;

import com.wule.dao.SelectDao;
import com.wule.pojo.FilmAllDate;
import com.wule.pojo.Seat;
import com.wule.pojo.User;

import java.sql.SQLException;
import java.util.List;

//创建于2022/6/21 11:31
public class SelectService
{
    /**
     * @作用 调用Dao层，根据用户号和密码查询是否有此人，可以用来查密码是否正确
     * @param userNum 用户号
     * @param userPassword 密码
     * @return List
     * @throws SQLException ,
     */
    public List<User> loginService(String userNum, String userPassword) throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.userLoginDao(userNum,userPassword);
    }


    /**
     * @作用 调用Dao层，返回本周电影所有信息。
     * @return List
     * @throws SQLException ,
     */
    public List<FilmAllDate> allFilmService() throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.getAllFilmDao();//返回表
    }


    /**
     * @作用 根据用户号查询用户所有信息
     * @param userNum 用户号
     * @return User 用户信息
     * @throws SQLException ,
     */
    public User userDataService(String userNum) throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.userDataDao(userNum);
    }


    /**
     * @作用 返回所有座位信息
     * @return List
     * @throws SQLException
     */
    public List<Seat> getSeatService(FilmAllDate filmAllDate) throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.getSeatDao(filmAllDate);
    }

    /**
     * @作用 根据用户号查询票仓。
     * @param userNum 用户号
     * @return List
     */
    public List<Seat> getTicketService(String userNum) throws SQLException
    {
        SelectDao selectDao = new SelectDao();
        return selectDao.getTicketDao(userNum);
    }

    /**
     * @作用 判断该用户是否有人；如果有人，则返回用户号。
     * @param filmAllDate 座位信息
     * @param seatNum 座位号
     * @return String userNum 用户号
     */
    public String getSeadUserNumService(FilmAllDate filmAllDate,String seatNum) throws SQLException
    {
        SelectDao selectDao = new SelectDao();

        return selectDao.getSeadUserNumDao(filmAllDate,seatNum);
    }

    /**
     * @作用 根据参数查询对应的电影信息。
     * @param filmName 电影名
     * @return List
     * @throws SQLException
     */
    public List<FilmAllDate> fromNameToFilmService(String filmName) throws SQLException
    {
        SelectDao selectDao = new SelectDao();
        List<FilmAllDate> list;

        return selectDao.fromNameToFilmDao(filmName);
    }


    /**
     * @作用 根据参数查询对应的电影信息。
     * @param Class
     * @return List
     * @throws SQLException
     */
    public List<FilmAllDate> fromClassToFilmService(String Class) throws SQLException
    {
        SelectDao selectDao = new SelectDao();

        return selectDao.fromClassToFilmDateDao(Class);
    }




//    public static void main(String[] args) throws SQLException
//    {
//        SelectService service = new SelectService();
//        List<Seat> list = service.getSeatService(new FilmAllDate("1","1","2022-6-21","2"));
//        int i = 0;
//        do
//        {
//            System.out.println(list.get(i++));
//        } while (list.size() != i);
//
//    }
}
