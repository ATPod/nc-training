<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h3>Вы вошли в систему как доктор</h3>
<h4>Выберите операцию:</h4>
<a href="controller?command=gotochoosepatient">Выбрать пациента</a> <br/>
<a href="controller?command=gotoaddpatient">Добавить пациента</a> <br/>
<a href="controller?command=logout">Выйти из системы</a> <br/>
</body>
</html>


