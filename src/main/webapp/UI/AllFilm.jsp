<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/22
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>本周电影</title>
</head>
<body>
<table border="1px" cellspacing="0" width="800px">
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
        <th>结束时间时间</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${list}" var="FilmAllDate" varStatus="status">
        <tr style="text-align:center">
            <td>${status.count}</td>
            <td>${FilmAllDate.cinemaNum}</td>
            <td>${FilmAllDate.filmDate}</td>
            <td>${FilmAllDate.eventNum}</td>
            <td>${FilmAllDate.event.filmNum}</td>
            <td>${FilmAllDate.filmName}</td>
            <td>${FilmAllDate.filmProfile}</td>
            <td>${FilmAllDate.filmClass}</td>
            <td>${FilmAllDate.filmPrice}</td>
            <td>${FilmAllDate.eventBeginTime}</td>
            <td>${FilmAllDate.eventEndTime}</td>
            <td>
                <form action="" method="get">
                    <input type="submit" name="购买" value="购买">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
