<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление процедуры</title>
</head>
<body>
<form name="addMedProcedureForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addMedProcedure" />
    Введите название:<br />
    <input type="text" name="medProcedureName" value="" />
    <input type="submit" value="Сохранить" /> <br />
    <a href="controller?command=backtomenu">Вернуться обратно</a>
    <a href="controller?command=backtologin">Выйти из системы</a>
    ${operationMessage}  <br />
</form>
</body>
</html>
