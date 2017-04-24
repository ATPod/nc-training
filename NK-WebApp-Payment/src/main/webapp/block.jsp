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
<form name="loginForm" method="POST"action="controller?command=BlockCreditCard">
    <input type="hidden" name="command" value="BlockCreditCard"/>
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
    </table>
    <input type="submit" value="Подтвердить"/>
</form>

</body>
</html>
