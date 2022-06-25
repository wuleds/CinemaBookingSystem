package com.wule.web;

import com.wule.pojo.FilmAllDate;
import com.wule.pojo.Seat;
import com.wule.pojo.User;
import com.wule.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//创建于2022/6/23 22:52
@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        User user;
        SelectService service = new SelectService();
        List<Seat> list;

        String userNum = req.getParameter("userNum");
        String cinemaNum = req.getParameter("cinemaNum");
        String filmDate = req.getParameter("filmDate");
        String eventNum = req.getParameter("eventNum");
        String filmNum = req.getParameter("filmNum");
        String filmPrice = req.getParameter("filmPrice");
        String filmName = req.getParameter("filmName");

        FilmAllDate filmAllDate = new FilmAllDate();

        int price;

        try
        {
            user = service.userDataService(userNum);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(user.getUserIntegration() >= 100)
        {
            price = (int) (Integer.parseInt(filmPrice) * 0.5);

        }else
        {
            price = Integer.parseInt(filmPrice);
        }

        filmAllDate.setCinemaNum(cinemaNum);
        filmAllDate.setFilmDate(filmDate);
        filmAllDate.setEventNum(eventNum);
        filmAllDate.setFilmNum(filmNum);
        filmAllDate.setFilmName(filmName);
        filmAllDate.setFilmPrice(String.valueOf(price));

        try
        {
            list = service.getSeatService(filmAllDate);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        req.setAttribute("price",price);
        req.setAttribute("user",user);
        req.setAttribute("filmAllDate",filmAllDate);
        req.setAttribute("seatList",list);

        req.getRequestDispatcher("/orders.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}
