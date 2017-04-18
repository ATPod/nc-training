<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Cache-Control" content="no-cache">
<html>
<head>
    <title>Список студентов</title>
</head>
<body>
<table border="1">
    <tr bgcolor="#afeeee">
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Баллы</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td align="left">${student.name}</td>
            <td align="left">${student.surname}</td>
            <td align="center">${student.scores}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
