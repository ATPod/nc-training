<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление диагноза</title>
</head>
<body>
<a href="controller?command=backtologin">Вход в систему</a>>
<a href="controller?command=backtochoosepatient">Выбор карточки пациента</a>>
<a href="controller?command=backtomenu">Карточка пациента</a>>Добавление диагноза<br/>
<form name="addDiagnosisForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addDiagnosis" />
    Введите название:<br />
    <input type="text" name="diagnosisName" value="" />
    <input type="submit" value="Сохранить" /> <br />
    ${operationMessage}  <br />
</form>
</body>
</html>

