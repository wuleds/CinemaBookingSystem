<%--
  Created by IntelliJ IDEA.
  User: 吴乐
  Date: 2022/6/21
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>院线订票系统首页</title>
</head>
<body>
    <c:if test="${user.userPower=='visitor'|| user.userNum != null}">

        <div  style="margin-top: 100px;margin-left: 600px">
            <input type="button" style="width: 200px;height: 50px" name="搜索" value="搜索">

        
        
        
        
        
        </div>
        
        
        
        
        
        
        
    </c:if>


    <c:if test="${user ==null}">
        <h3>登录失败</h3>
        <a href="UI/login.html">返回</a>
    </c:if>
</body>
</html>
