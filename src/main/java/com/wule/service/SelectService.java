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
     * @param userNum ,
     * @param userPassword ,
     * @return List
     * @throws SQLException ,
     */
    public List<User> login(String userNum,String userPassword) throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.userLogin(userNum,userPassword);
    }


    /**
     * @作用 调用Dao层，返回本周电影所有信息。
     * @return List
     * @throws SQLException ,
     */
    public List<FilmAllDate> allFilmService() throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.allFilmDao();//返回表
    }


    /**
     * @作用 根据用户号查询用户所有信息
     * @param userNum ,
     * @return User
     * @throws SQLException ,
     */
    public User userData(String userNum) throws SQLException {
        SelectDao selectdao = new SelectDao();
        return selectdao.userData(userNum);
    }


    /**
     * @作用 返回所有座位信息
     * @return List
     * @throws SQLException
     */
    public List<Seat> getSeat() throws SQLException {
        SelectDao selectdao = new SelectDao();
        List<Seat> list = selectdao.getSeat();
        return list;
    }
//
//    public static void main(String[] args) throws SQLException
//    {
//        SelectService service = new SelectService();
//        List<FilmAllDate> list = service.allFilmService();
//        int i = 0;
//        do
//        {
//            System.out.println(list.get(i++));
//        } while (list.size() != i);
//
//        User user;
//        user = service.userData("1");
//        System.out.println(user);
//
//    }
}
