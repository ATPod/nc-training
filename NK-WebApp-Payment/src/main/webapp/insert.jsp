<%--
  Created by IntelliJ IDEA.
  User: AsusPC
  Date: 18.04.17
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
</head>
<body>
<form name="loginForm" method="POST"action="controller?command=InsertCreditCard">
    <input type="hidden" name="command" value="InsertCreditCard"/>
    <p><b>Вход в систему:</b></p>
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
