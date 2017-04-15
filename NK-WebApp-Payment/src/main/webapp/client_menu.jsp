<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Здравствуйте, </h2>
<h3>Вы вошли в систему</h3>
<h4>Выберите операцию:</h4>
<a href="controller?command=showcreditcards">Посмотреть список кредитных карт</a> <br/>
<a href="controller?command=refil">Пополнить счёт кредитной карты</a> <br/>
<a href="controller?command=payment">Совершить платёж</a> <br/>
<a href="controller?command=LogoutUser">Выйти из системы</a> <br/>
</body>
</html>