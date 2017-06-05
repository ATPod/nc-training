<%--
  Created by IntelliJ IDEA.
  User: AsusPC
  Date: 24.04.17
  Time: 11:31
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
    <a href="controller?command=AdminMenu">Вход в систему</a>>
    <a href="./admin_menu.jsp">${person.name}</a>>
    Разблокировка
</h1>
<form name="loginForm" method="POST"action="controller?command=Unblock">
    <input type="hidden" name="command" value="Unblock"/>
    <p><b>Введите данные:</b></p>
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="cr_id" value="" size="20" placeholder="Введите айди..."/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>
