<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/22
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>本周电影</title>
</head>
<body>

<div style="margin-top: 100px;margin-left:300px;">
<table border="1px" cellspacing="0" width="900px">
    <tr>
        <th>序号</th>
        <th>放映厅号</th>
        <th>播放日期</th>
        <th>场次号</th>
        <th>电影号</th>
        <th>电影名</th>
        <th>电影简介</th>
        <th>电影分类</th>
        <th>电影价格</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="FilmAllDate" varStatus="status">
        <tr style="text-align:center">

            <td>${status.count}</td>
            <td>${FilmAllDate.cinemaNum}</td>
            <td>${FilmAllDate.filmDate}</td>
            <td>${FilmAllDate.eventNum}</td>
            <td>${FilmAllDate.filmNum}</td>
            <td>${FilmAllDate.filmName}</td>
            <td>${FilmAllDate.filmProfile}</td>
            <td>${FilmAllDate.filmClass}</td>
            <td>${FilmAllDate.filmPrice}￥</td>
            <td>${FilmAllDate.eventBeginTime}</td>
            <td>${FilmAllDate.eventEndTime}</td>

            <td>
                <c:if test="${user.userPower == 'visitor'}">
                    <a href="login.html">请登录</a>
                </c:if>

                <c:if test="${user.userPower != 'visitor'}">
                     <a href="/DatabaseHomework_war/ordersServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}&userName=${userName}
                     &cinemaNum=${FilmAllDate.cinemaNum}&filmDate=${FilmAllDate.filmDate}&eventNum=${FilmAllDate.eventNum}
                &filmNum=${FilmAllDate.filmNum}&filmPrice=${FilmAllDate.filmPrice}&filmName=${FilmAllDate.filmName}">
                        <input type="submit" value="购买">
                    </a>
                </c:if>
            </td>
        </tr>
    </c:forEach>

</table>

    <a href="/DatabaseHomework_war/userLoginServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}">
        <input type="submit" style="width: 150px;height: 30px ;margin-left: 400px;margin-top: 10px" value="返回主页面">
    </a>

</div>
</body>
</html>
