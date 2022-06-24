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
    <title>购买成功</title>
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

                <br>
                <c:forEach items="${seatList}" var="seat" varStatus="id">

                    <a href="/DatabaseHomework_ear/byTicketServlet?userNum=${user.userNum}&userPower=${user.userPower}&userPassword=${user.userPassword}&userName=${userName}
                        &cinemaNum=${FilmAllDate.cinemaNum}&filmDate=${FilmAllDate.filmDate}&eventNum=${FilmAllDate.eventNum}
                        &filmNum=${FilmAllDate.filmNum}&filmPrice=${FilmAllDate.filmPrice}&filmName=${FilmAllDate.filmName}&seatNum=${seat.seatNum}">
                            ${seat.seatNum}号位
                    </a>
                    <c:if test="${id.count == '5' || id.count == '10' || id.count == '15'}">
                        <br>
                    </c:if>
                </c:forEach>
            </div>
        </div>
</body>
</html>
