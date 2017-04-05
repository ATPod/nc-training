<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/error.jsp" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<h1>Добро пожаловать в систему тестирования!</h1>
<a href="controller?command=GoToLogin">Войти</a> <br/>
<a href="controller?command=GoToRegistration">Зарегистрироваться</a> <br/>
</body>
</html>
