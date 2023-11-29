<%--
  Created by IntelliJ IDEA.
  User: Croco
  Date: 08/11/2023
  Time: 09:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="ControllerServlet" method="post">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <button type="submit">Login</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
