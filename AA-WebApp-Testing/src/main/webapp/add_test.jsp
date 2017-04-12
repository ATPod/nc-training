<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> Количество вопросов: ${questionAmount}</p>
<table>
<c:forEach var="question" items="${questions}">
    <tr>
        <td>Текст вопроса</td>
        <td>${question}</td>
    </tr>
</c:forEach>
    </table>
</body>
</html>
