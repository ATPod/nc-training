<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Cache-Control" content="no-cache">
<html>
<head>
    <title>Доступные тесты</title>
</head>
<body>
<form name="testsTable" method="POST"action="controller?command=ShowTest">
    <input type="hidden" name="command" value="ShowTest"/>
<table border="1">
    <tr bgcolor="#afeeee">
        <th>Название теста</th>
        <th>Предмет</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach var="test" items="${tests}">
        <tr>
            <td align="left">${test.name}</td>
            <td align="left">${test.subject}</td>
            <td align="left"><button type="submit" value="${test.id}" name="testId">Пройти тест</button></td>
        </tr>
    </c:forEach>
</table>
    </form>
</body>
</html>
