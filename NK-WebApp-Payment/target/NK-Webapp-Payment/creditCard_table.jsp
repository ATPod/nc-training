<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>
    <a href="controller?command=LogoutUser">Главная</a>>
    <a href="controller?command=ClientMenu">Вход в систему</a>>
    <a href="./client_menu.jsp">${person.name}</a>>
    Список карт
</h1>
<table>
    <c:forEach var="creditcard" items="${creditCards}">
        <tr>
            <td>ID:</td>
            <td>${creditcard.id.toString()}</td>
            <td>Сумма на счёте:</td>
            <td>${creditcard.account.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
