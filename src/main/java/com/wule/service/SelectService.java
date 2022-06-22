package com.wule.service;

import com.wule.dao.SelectDao;
import com.wule.pojo.FilmAllDate;
import com.wule.pojo.User;

import java.sql.SQLException;
import java.util.List;

//创建于2022/6/21 11:31
public class SelectService
{
    public List<User> login(String userNum,String userPassword) throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.userLogin(userNum,userPassword);
    }


    /**
     * @作用 调用Dao层，返回本周电影所有信息。
     * @return List
     * @throws SQLException
     */
    public List<FilmAllDate> allFilmService() throws SQLException
    {
        SelectDao selectdao = new SelectDao();
        return selectdao.allFilmDao();//返回表
    }

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
//    }
}
