package com.wule.service;

import com.wule.dao.InsertIntoDao;
import com.wule.dao.SelectDao;
import com.wule.pojo.FilmAllDate;
import com.wule.pojo.User;

import java.sql.SQLException;
import java.util.List;

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

        if(user.getUserNum() != null && user.getUserPassword() != null && user.getUserName() != null)
        {
            if(selectDao.loginDao(user.getUserNum()))
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
        return false;
    }

    /**
     * @作用 给用户加积分，票仓加票。
     * @param userNum
     * @param cinemaNum
     * @param filmDate
     * @param eventNum
     * @param filmNum
     * @param filmPrice
     * @throws SQLException
     */
    public void byTicketService(String userNum,String cinemaNum,String filmDate,String eventNum,
                                String filmNum,int filmPrice) throws SQLException
    {
        InsertIntoDao insertIntoDao = new InsertIntoDao();

        insertIntoDao.byTicketDao(userNum,cinemaNum,filmDate,eventNum,filmNum,filmPrice);
    }


    /**
     * @作用 按照参数添加参数个座位
     * @param filmAllDate
     * @throws SQLException
     */
    public void addSeat(FilmAllDate filmAllDate) throws SQLException
    {
        int seatCount = 20;
        InsertIntoDao insertIntoDao = new InsertIntoDao();

        for(int i = 1;i <= seatCount;i++)
            insertIntoDao.addSeatDao(filmAllDate,i);
    }

    /**
     * @作用 查询本周所有电影，然后给所有场次添加座位
     */
    public void addAllEventSeat() throws SQLException {
        InsertIntoService service = new InsertIntoService();
        SelectDao dao = new SelectDao();
        List<FilmAllDate> list = dao.getAllFilmDao();

        int i=0;
        do
        {
            service.addSeat(list.get(i++));
        } while (i != list.size());

    }

//    public static void main(String[] args) throws SQLException {
//        InsertIntoService service = new InsertIntoService();
//        service.addAllEventSeat();
//    }
}
