<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/23
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div id="div1">
    <div id="div2">

        <c:if test="${user.userPower=='visitor'}">
            <h1>您是游客</h1>
        </c:if>

        <c:if test="${user.userPower != 'visitor'}">
            <p>用户号:&nbsp;${user.userNum}</p>
            <p>用户名:&nbsp;${user.userName}</p>
            <p>密码:&nbsp;${user.userPassword}</p>
            <p>权限:&nbsp;${user.userPower}</p>
            <p>积分:&nbsp;${user.userIntegration}</p>
        </c:if>

        <h1>
            <a href="/DatabaseHomework_war/userLoginServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}">
                <input style="width: 200px;height: 50px;margin-top: 20px" type="submit" value="返回主页面">
            </a>
        </h1>

    </div>
</div>
</body>
</html>
