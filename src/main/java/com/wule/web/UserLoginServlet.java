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
import java.util.List;

//创建于2022/6/21 11:39
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<User> list;
        User user = null;
        SelectService service = new SelectService();

        String userNum = req.getParameter("userNum");
        String userPassword = req.getParameter("userPassword");
        //用户输入账户密码

        if(req.getParameter("userPower") != null && "visitor".equals(req.getParameter("userPower")))
        {
            user = new User();
            user.setUserPower("visitor");//标记为游客
        }
        else//如果不为游客
        {
            try
            {
                list = service.loginService(userNum,userPassword);//查询数据库是否有此人
            } catch (SQLException e)
            {
                throw new RuntimeException(e);
            }

            if(list!=null)//如果不为空说明有此人。
            {
                user = list.get(0);
            }

        }

        req.setAttribute("user",user);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
