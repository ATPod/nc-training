<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Выбор действия</title>
</head>
<body>
Карточка пациента " ${patientName} "
<form name="nurseMenuForm" method="POST" action="controller">
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"><strong>Выполнить</strong></td>
        </tr>
        <tr>
            <td><a href="controller?command=gotochoosedrug">Ввести лекарство</a></td>
        </tr>
        <tr>
            <td><a href="controller?command=gotochooseprocedure">Сделать процедуру</a></td>
        </tr>
    </table>
    <a href="controller?command=backtochoosepatient">Вернуться к выбору пациента</a><br/>
    <a href="controller?command=backtologin">Выйти из системы</a><br/>
    ${operationMessage}  <br />
</form>
</body>
</html>

