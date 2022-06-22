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


    public List<FilmAllDate> allFilmService()
    {

    }

//    public static void main(String[] args) throws SQLException
//    {
//        SelectService service = new SelectService();
//        List<User> list = service.login("1","123456");
//
//    }
}
