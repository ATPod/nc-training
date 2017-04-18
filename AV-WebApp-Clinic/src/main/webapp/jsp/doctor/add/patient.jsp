<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление пациента</title>
</head>
<body>
    <form name="addPatientForm" method="POST" action="controller">
        <input type="hidden" name="command" value="addPatient" />
        Введите ФИО:<br />
        <input type="text" name="patientName" value="" />
        <input type="submit" value="Сохранить" /> <br />
        ${operationMessage}  <br />
        <a href="controller?command=backtodoctormain">Вернуться обратно</a>
        <a href="controller?command=logout">Выйти из системы</a>
    </form>
</body>
</html>
