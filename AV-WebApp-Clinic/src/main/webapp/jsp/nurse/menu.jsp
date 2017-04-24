<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Выбор действия</title>
</head>
<body>
<strong>Карточка пациента " ${patientName} "</strong>
<table align="top">
    <tr>
        <td valign="top" style="text-align: center">
            <form name="drugListForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delDrug" />
                <input type="submit" value="Ввести лекарство" align="center"/>  <br/>
                <table align="center" border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Лекарства</strong></td>
                    </tr>
                    <c:if test="${empty drugsList}">
                        <tr>
                            <td>Нет записей.</td>
                        </tr>
                    </c:if>
                    <c:forEach var="drug" items="${drugsList}">
                        <tr>
                            <td><input type="radio" name="drugId" value="${ drug.id }"/> <c:out value="${ drug.name }" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </td>
        <td valign="top" style="text-align: center">
            <form name="procedureListForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delProcedure" />
                <input type="submit" value="Сделать процедуру" align="center"/>  <br/>
                <table align="center" border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Процедуры</strong></td>
                    </tr>
                    <c:if test="${empty proceduresList}">
                        <tr>
                            <td>Нет записей.</td>
                        </tr>
                    </c:if>
                    <c:forEach var="procedure" items="${proceduresList}">
                        <tr>
                            <td><input type="radio" name="procedureId" value="${ procedure.id }"/> <c:out value="${ procedure.name }" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </td>
    </tr>
</table>
<a href="controller?command=backtochoosepatient">Вернуться к выбору пациента</a><br/>
<a href="controller?command=backtologin">Выйти из системы</a><br/>
${operationMessage}  <br />
</body>
</html>



