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
<h1>
    <a href="controller?command=LogoutUser">Главная</a>>
    <a href="controller?command=ClientMenu">Вход в систему</a>>
    ${person.name}
</h1>
<h4>Выберите операцию:</h4>
<a href="controller?command=showcreditcards">Посмотреть список кредитных карт</a> <br/>
<a href="controller?command=GoToRefil">Пополнить счёт кредитной карты</a> <br/>
<a href="controller?command=GoToPayment">Совершить платёж</a> <br/>
<a href="controller?command=GoToInsertCreditCard">Добавить карту</a> <br/>
<a href="controller?command=GoToDeleteCreditCard">Удалить карту</a> <br/>
<a href="controller?command=GoToBlockCreditCard">Заблокировать карту</a> <br/>
<a href="controller?command=LogoutUser">Выйти из системы</a> <br/>
</body>
</html>