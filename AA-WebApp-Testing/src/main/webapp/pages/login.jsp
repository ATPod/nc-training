<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/pages/error.jsp" %>
<meta http-equiv="Cache-Control" content="no-cache">
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<div align="center">
    <font color="#8b0000"><b>${error_message}</b></font>
    <form name="loginForm" method="POST" action="controller?command=Login">
        <input type="hidden" name="command" value="Login"/>
        <p><b>Вход в систему: </b></p>
        <table>
            <tr>
                <td>Логин:</td>
                <td><input type="text" name="login" value="" size="20" placeholder="Введите логин..."/></td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type="password" name="password" value="" size="20" placeholder="Введите пароль..."/></td>
            </tr>
        </table>
        <input type="submit" value="Войти"/>
    </form>
</div>
</body>
</html>
