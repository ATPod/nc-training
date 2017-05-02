<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<a href="controller?command=backtologin">Вход в систему</a>>Страница ошибки<br/>
Извините, но в данный момент сервис не доступен: <br/>
${operationMessage}<br />
</body>
</html>