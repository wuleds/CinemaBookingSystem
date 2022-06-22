package com.wule.web;

import com.wule.dao.SelectDao;
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

//创建于2022/6/21 16:22
@WebServlet("/signupServlet")
public class SignupServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        InsertIntoService insertIntoService = new InsertIntoService();
        User user;

        String userNum = req.getParameter("userNum");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String userPasswordToo = req.getParameter("userPasswordToo");

        if(userPassword.length()>=6&&userNum.length()>=6&&userName.length()>=1 && userPassword.equals(userPasswordToo))
        {
            try {
                user = new User(userNum,userName,userPassword,"user",0);
                if (insertIntoService.addUserService(user))
                {
                    req.getRequestDispatcher("/UI/signupYes.jsp").forward(req,resp);
                    //注册成功
                }else
                {
                    req.getRequestDispatcher("/UI/signupError.jsp").forward(req,resp);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            req.getRequestDispatcher("/UI/signupError.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
