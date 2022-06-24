package com.wule.web;

import com.wule.pojo.FilmAllDate;
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

//创建于2022/6/21 11:53
@WebServlet("/homeAllFilmServlet")
public class HomeAllFilmServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        SelectService service = new SelectService();
        List<FilmAllDate> list;
        User user;

        String userPower = req.getParameter("userPower");

        if("visitor".equals(userPower))
        {
            user = new User();
            user.setUserPower("visitor");
        }
        else
        {
            String userNum = req.getParameter("userNum");
            try {
                user = service.userDataService(userNum);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        //?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}&userName=${userName}&userIntegration=${user.userIntegration}

        try {
            list = service.allFilmService();
            //获取电影信息
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        req.setAttribute("list",list);
        //传递电影表
        req.setAttribute("user",user);
        //传递用户信息
        req.getRequestDispatcher("/AllFilm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}
