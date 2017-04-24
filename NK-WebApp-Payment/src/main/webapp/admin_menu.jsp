<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h2>Здравствуйте,${person.name}</h2>
<h3>Вы вошли в систему</h3>
<h4>Выберите операцию:</h4>
<a href="controller?command=GoToUnblock">Разблокировать карту</a> <br/>
<a href="controller?command=LogoutUser">Выйти из системы</a> <br/>
</body>
</html>