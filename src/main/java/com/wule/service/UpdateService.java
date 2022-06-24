package com.wule.service;

import com.wule.dao.SelectDao;
import com.wule.dao.UpdateDao;
import com.wule.pojo.FilmAllDate;

import java.sql.SQLException;

//创建于2022/6/25 0:20
public class UpdateService
{
    /**
     * @作用 给座位添加用户号，等于座位已售出；会判断该座位是否有人；如果有人则返回false。
     * @param filmAllDate
     * @param seatNum
     * @param userNum
     * @return true：没卖，添加成功；false：已卖，添加失败
     * @throws SQLException
     */
    public boolean addUserToSeatService(FilmAllDate filmAllDate, String seatNum, String userNum) throws SQLException {
        UpdateDao updateDao = new UpdateDao();
        SelectDao selectDao = new SelectDao();

        //判断该座位是否有人
        if(selectDao.getSeadUserNumDao(filmAllDate,seatNum) == null)//没人则添加用户号
        {
            updateDao.addUserToSeatDao(filmAllDate,seatNum,userNum);
            return true;
        }
        return false;
    }
}
