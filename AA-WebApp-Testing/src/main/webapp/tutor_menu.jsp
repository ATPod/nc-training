<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h2>Здравствуйте,${user.name} ${user.surname}</h2>
<h3>Вы вошли в систему</h3>
<h4>Выберите операцию:</h4>
<a href="controller?command=showtests">Добавить тест в систему</a> <br/>
<a href="controller?command=showresults">Просмотреть список студентов</a> <br/>
<a href="controller?command=LogoutUser">Выйти из системы</a> <br/>
</body>
</html>
