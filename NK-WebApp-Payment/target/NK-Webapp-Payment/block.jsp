<%--
  Created by IntelliJ IDEA.
  User: AsusPC
  Date: 24.04.17
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <a href="controller?command=LogoutUser">Главная</a>>
    <a href="controller?command=ClientMenu">Вход в систему</a>>
    <a href="./client_menu.jsp">${person.name}</a>>
    Блокировка
</h1>
<form name="loginForm" method="POST" action="controller?command=DeleteCreditCard">
    <p><b>Какую карту заблокировать?</b></p>
    <c:forEach var="creditcard" items="${creditCards}">
        <p><input name="dzen" type="radio" value="${creditcard.id.toString()}"> ${creditcard.id.toString()}</p>
    </c:forEach>
    <p><input type="submit" value="Заблокировать"></p>
</form>
</body>
</html>
