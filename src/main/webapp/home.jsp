<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/21
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>院线订票系统首页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <c:if test="${user.userPower=='visitor'|| user.userNum != null}">

        <div  style="margin-top: 100px;margin-left: 600px">

            <a href="/DatabaseHomework_war/userDataServlet?userPower=${user.userPower}&userNum=${user.userNum}">
                <input type="button" style="width: 200px;height: 50px;margin-top: 20px" value="用户信息">
            </a>

            <a href="">
                <input type="button" style="width: 200px;height: 50px;margin-top: 20px" value="搜索">
            </a>

            <a href="/DatabaseHomework_war/homeAllFilmServlet?userPower=${user.userPower}&userNum=${user.userNum}&userPassword=${user.userPassword}">
                <input type="button" style="width: 200px;height: 50px;margin-top: 20px" value="本周电影">
            </a>

        </div>

    </c:if>

    <c:if test="${user ==null}">

        <div id="div1">
            <div id="div2">
                <h1 style="color: red">登录失败</h1>
                <h1><a href="login.html">返回</a></h1>
            </div>
        </div>

    </c:if>

</body>
</html>
