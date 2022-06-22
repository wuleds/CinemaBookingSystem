package com.wule.web;

import com.wule.pojo.FilmAllDate;
import com.wule.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//创建于2022/6/21 11:53
@WebServlet("/homeAllFilmServlet")
public class HomeAllFilmServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        SelectService service = new SelectService();
        List<FilmAllDate> list;

        try {
            list = service.allFilmService();
            //获取电影信息
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        req.setAttribute("list",list);
        //传递电影表
        req.getRequestDispatcher("/UI/AllFilm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}
