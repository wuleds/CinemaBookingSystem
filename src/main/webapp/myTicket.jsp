<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/25
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的电影票</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

<c:if test="${user.userPower == 'visitor'}">
        <h1>您是游客</h1>
</c:if>

<c:if test="${user.userPower != 'visitor'}">


    <div style="margin-top: 100px;margin-left:500px">
        <table border="1px" cellspacing="0" width="500px">
            <tr>
                <th>计数</th>
                <th>放映厅号</th>
                <th>播放日期</th>
                <th>场次号</th>
                <th>电影号</th>
                <th>座位号</th>
            </tr>

            <c:forEach items="${ticketList}" var="ticket" varStatus="id">
                <tr>
                    <td>${id.count}</td>
                    <td>${ticket.cinemaNum}</td>
                    <td>${ticket.filmDate}</td>
                    <td>${ticket.eventNum}</td>
                    <td>${ticket.filmNum}</td>
                    <td>${ticket.seatNum}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</c:if>
<h1>
    <a href="/DatabaseHomework_war/userLoginServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}">
        <input type="button" style="width: 150px;height: 30px;margin-top: 10px;margin-left:670px" value="返回主页面">
    </a>
</h1>
</body>
</html>
