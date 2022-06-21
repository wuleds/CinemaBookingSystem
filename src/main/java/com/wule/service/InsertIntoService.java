package com.wule.service;

import com.wule.dao.InsertIntoDao;
import com.wule.dao.SelectDao;
import com.wule.pojo.User;

import java.sql.SQLException;

//创建于2022/6/21 15:24
public class InsertIntoService
{
    /**
     * @作用 判断数据是否有空的，判断用户是否存在，然后下达注册命令。
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean addUserService(User user) throws SQLException
    {
        InsertIntoDao insertIntoDao = new InsertIntoDao();
        SelectDao selectDao = new SelectDao();

        if(user.getUserNum()==null||user.getUserPassword()==null||user.getUserName()==null)
        {
            return false;
        }

        if(selectDao.login(user.getUserNum()))
            //判断该用户号是否已经存在
        {
            insertIntoDao.addUserDao(user);
            return true;
        }
        else
        {
            return false;
        }
    }

}
