
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Выбор действия</title>
</head>
<body>
Карточка пациента " ${patientName} "
    <form name="doctorMenuForm" method="POST" action="controller">
        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>Записать в карточку</strong></td>
                <td align="center"><strong>Выполнить</strong></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoadddiagnosis">Диагноз</a></td>
                <td><a href="controller?command=gotochoosediagnosis">Снять диагноз</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoadddrug">Лекарство</a></td>
                <td><a href="controller?command=gotochoosedrug">Ввести лекарство</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoaddprocedure">Процедура</a></td>
                <td><a href="controller?command=gotochooseprocedure">Сделать процедуру</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoaddsurgery">Операция</a></td>
                <td><a href="controller?command=gotochoosesurgery">Сделать операцию</a></td>
            </tr>
        </table>
        <a href="controller?command=delpatient">Выписать пациента (удалить карточку)</a><br/>
        <a href="controller?command=backtochoosepatient">Вернуться к выбору пациента</a><br/>
        <a href="controller?command=backtologin">Выйти из системы</a><br/>
        ${operationMessage}  <br />
    </form>
</body>
</html>

