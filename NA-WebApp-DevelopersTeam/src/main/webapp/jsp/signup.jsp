<%@ page import="by.training.nc.dev5.accounts.UserRole" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 03.05.2017
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2>Sign up new user</h2>

        <form method="post" action="controller">
            <input type="hidden" name="command" value="signUp">

            <div class="form-group">
                <label for="userRoleSelect">User role:</label>
                <select name="userRole" id="userRoleSelect">
                    <c:forEach var="userRole" items="${requestScope.roles}">
                        <option value="${userRole}">${userRole}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>
                    Login:
                    <input type="text" name="login">
                </label>
            </div>
            <div class="form-group">
                <label>
                    Password:
                    <input type="password" name="password">
                </label>
            </div>
            <div class="form-group">
                <label>
                    Name:
                    <input type="text" name="name">
                </label>
            </div>
        </form>
    </div>
</body>
</html>
