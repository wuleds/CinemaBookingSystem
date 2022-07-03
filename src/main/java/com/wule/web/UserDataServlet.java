package com.wule.web;

import com.wule.pojo.User;
import com.wule.service.SelectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//创建于2022/6/23 15:51
@WebServlet("/userDataServlet")
public class UserDataServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        User user = new User();
        String userNum = req.getParameter("userNum");
        String userPower = req.getParameter("userPower");
        SelectService service = new SelectService();



        if (userPower.equals("visitor"))
        {
            user.setUserPower(userPower);
        }
        else
        {
            try
            {//获取用户全部信息
                user = service.userDataService(userNum);
            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        req.setAttribute("user",user);
        req.getRequestDispatcher("/UserData.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req,resp);
    }
}
