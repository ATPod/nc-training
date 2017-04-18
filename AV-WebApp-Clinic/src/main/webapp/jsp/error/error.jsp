<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
Извините, но в данный момент сервис не доступен: <br/>
<a href="controller?command=logout">Назад</a>
${errorDatabase} <br/>
</body>
</html>