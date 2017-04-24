<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="loginForm" method="POST"action="controller?command=payment">
    <input type="hidden" name="command" value="payment"/>
    <p><b>Введите данные:</b></p>
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="cr_id" value="" size="20" placeholder="Введите айди..."/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="cr_password" value="" size="20" placeholder="Введите пароль..."/></td>
        </tr>
        <tr>
            <td>Сумма:</td>
            <td><input type="text" name="money" value="" size="20" placeholder="Введите сумму..."/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>
