<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление пациента</title>
</head>
<body>
    <a href="controller?command=backtologin">Вход в систему</a>>
    <a href="controller?command=backtochoosepatient">Выбор карточки пациента</a>>
    Добавление новой карточки<br/>
    <form name="addPatientForm" method="POST" action="controller">
        <input type="hidden" name="command" value="addPatient" />
        Введите ФИО:<br />
        <input type="text" name="patientName" value="" />
        <input type="submit" value="Сохранить" /> <br />
        ${operationMessage}  <br />
    </form>
</body>
</html>
