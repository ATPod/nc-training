<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление операции</title>
</head>
<body>
<form name="addSurgeryForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addSurgery" />
    Введите название:<br />
    <input type="text" name="surgeryName" value="" />
    <input type="submit" value="Сохранить" /> <br />
    <a href="controller?command=backtomenu">Вернуться обратно</a>
    <a href="controller?command=backtologin">Выйти из системы</a>
    ${operationMessage}  <br />
</form>
</body>
</html>
