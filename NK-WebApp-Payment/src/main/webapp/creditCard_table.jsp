<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h2>Здравствуйте, ${person.name}</h2>
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
