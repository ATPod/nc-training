<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h1>
    <a href="controller?command=LogoutUser">Главная</a>>
    <a href="controller?command=ClientMenu">Вход в систему</a>>
    ${person.name}
</h1>
<h4>Выберите операцию:</h4>
<a href="controller?command=GoToUnblock">Разблокировать карту</a> <br/>
<a href="controller?command=LogoutUser">Выйти из системы</a> <br/>
</body>
</html>