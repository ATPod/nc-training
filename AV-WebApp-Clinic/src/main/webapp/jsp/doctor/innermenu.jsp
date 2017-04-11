<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.04.2017
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Выбор действия</title>
</head>
<body>
    <form name="doctorInnerMenuForm" method="POST" action="controller">
        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>Записать в карточку</strong></td>
                <td align="center"><strong>Выполнить</strong></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoadddiagnosis">Диагноз</a></td>
                <td><a href="controller?command=gotodeldiagnosis">Снять диагноз</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoadddrug">Лекарство</a></td>
                <td><a href="controller?command=gotodeldrug">Ввести лекарство</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoaddprocedure">Процедура</a></td>
                <td><a href="controller?command=gotodelprocedure">Сделать процедуру</a></td>
            </tr>
            <tr>
                <td><a href="controller?command=gotoaddsurgery">Операция</a></td>
                <td><a href="controller?command=gotodelsurgery">Сделать операцию</a></td>
            </tr>
        </table>
        <a href="controller?command=delpatient">Выписать пациента (удалить карточку)</a><br/>
        <a href="controller?command=backtochoosepatient">Вернуться к выбору пациента</a><br/>
        <a href="controller?command=logout">Выйти из системы</a><br/>
    </form>
</body>
</html>

