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
</head>
<body>
    <h2>Sign up new user</h2>

    <form method="post" action="controller">
        <input type="hidden" name="command" value="signUp">

        <label for="userRoleSelect">User role:</label>
        <select name="userRole" id="userRoleSelect">
            <%-- TODO: review this "sistema nipel" --%>
            <jsp:useBean
                    id="userRoles"
                    scope="application"
                    type="by.training.nc.dev5.accounts.UserRole[]" />
            <c:forEach var="userRole" items="${userRoles}">
                <option value="${userRole}">${userRole}</option>
            </c:forEach>
        </select>

        <label>
            Login:
            <input type="text" name="login">
        </label>
        <label>
            Password:
            <input type="password" name="password">
        </label>
        <label>
            Name:
            <input type="text" name="name">
        </label>
    </form>
</body>
</html>
