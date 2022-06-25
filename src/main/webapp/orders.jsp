<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/23
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
        <div id="div1">
            <div id="div2">
                用户号：&nbsp;${user.userNum}
                用户名：&nbsp;${user.userName}
                放映厅号：&nbsp;${filmAllDate.cinemaNum}
                <br>
                播放日期：&nbsp;${filmAllDate.filmDate}
                场次号：&nbsp;${filmAllDate.eventNum}
                <br>
                电影号：&nbsp;${filmAllDate.filmNum}
                电影名：&nbsp;${filmAllDate.filmName}
                <Strong>价格：${price}</Strong>
                <br>

                剩余座位：
                <br>
                <c:forEach items="${seatList}" var="seat" varStatus="id">

                    <c:if test="${seat.userNum == null}">
                          <a href="/DatabaseHomework_war/byTicketServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}&cinemaNum=${filmAllDate.cinemaNum}&filmDate=${filmAllDate.filmDate}&eventNum=${filmAllDate.eventNum}&filmNum=${filmAllDate.filmNum}&filmPrice=${filmAllDate.filmPrice}&seatNum=${seat.seatNum}">
                               ${seat.seatNum}&nbsp;
                          </a>
                    </c:if>
                    <c:if test="${id.count == '10'}">
                        <br>
                        <br>
                    </c:if>
                </c:forEach>
                <br>
                <br>
                <a href="/DatabaseHomework_war/homeAllFilmServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}">
                    <input type="button" style="width: 200px;height: 50px;margin-top: 20px" value="返回">
                </a>

            </div>
        </div>
</body>
</html>
