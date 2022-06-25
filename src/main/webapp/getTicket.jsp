<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/25
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购票成功</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="div1">
    <div id="div2">
        <h1>购票成功</h1>
        <a href="/DatabaseHomework_war/userLoginServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}">
            <input type="button" style="width: 200px;height: 50px;margin-top: 20px" value="返回主界面">
        </a>
    </div>
</div>
</body>
</html>
