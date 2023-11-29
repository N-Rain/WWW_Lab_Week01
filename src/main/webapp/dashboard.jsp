<%--
  Created by IntelliJ IDEA.
  User: Croco
  Date: 21/09/2023
  Time: 09:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý tài khoản</title>
</head>
<body>
<p>Welcome, <%= session.getAttribute("usrname")%></p>
<p>Your Roles: <%= session.getAttribute("role")%></p>
</body>
</html>
