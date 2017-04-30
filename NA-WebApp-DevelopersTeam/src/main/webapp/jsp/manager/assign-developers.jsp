<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 26.04.2017
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign developers</title>
</head>
<body>
    <jsp:useBean
            id="managerService"
            scope="application"
            class="by.training.nc.dev5.service.ManagerService" />
    <jsp:useBean
            id="qualification"
            scope="request"
            class="by.training.nc.dev5.entity.Qualification" />

    <label for="qualificationSelect">Qualification:</label>
    <select id="qualificationSelect" name="qualificationId"></select>
    <table>
        <tr><td></td><td>Name</td><td>Qualification</td></tr>
    <c:forEach var="developer" items="${managerService.unassignedDevelopers}">
        <tr></tr>
    </c:forEach>
    </table>
</body>
</html>
