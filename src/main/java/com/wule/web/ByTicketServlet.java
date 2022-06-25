package com.wule.web;

import com.wule.pojo.FilmAllDate;
import com.wule.pojo.User;
import com.wule.service.InsertIntoService;
import com.wule.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//创建于2022/6/22 23:21
@WebServlet("/byTicketServlet")
public class ByTicketServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        User user;
        SelectService service = new SelectService();
        InsertIntoService insert = new InsertIntoService();

        String userNum = req.getParameter("userNum");
        String cinemaNum = req.getParameter("cinemaNum");
        String filmDate = req.getParameter("filmDate");
        String eventNum = req.getParameter("eventNum");
        String filmNum = req.getParameter("filmNum");
        String filmPrice = req.getParameter("filmPrice");
        String seatNum = req.getParameter("seatNum");

        int price = 0;

        try
        {//查询用户信息
            user = service.userDataService(userNum);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        if(user.getUserIntegration() >= 100)
        {
            filmPrice  = "-100";//打折扣积分
        }

        //向数据库添加信息
        try
        {
            insert.byTicketService(userNum,cinemaNum,filmDate,eventNum,filmNum,seatNum,Integer.parseInt(filmPrice));
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        req.setAttribute("user",user);
        req.getRequestDispatcher("/getTicket.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
