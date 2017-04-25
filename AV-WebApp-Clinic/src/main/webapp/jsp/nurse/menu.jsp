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
            <form name="medProcedureListForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delMedProcedure" />
                <input type="submit" value="Сделать процедуру" align="center"/>  <br/>
                <table align="center" border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Процедуры</strong></td>
                    </tr>
                    <c:if test="${empty medProceduresList}">
                        <tr>
                            <td>Нет записей.</td>
                        </tr>
                    </c:if>
                    <c:forEach var="medProcedure" items="${medProceduresList}">
                        <tr>
                            <td><input type="radio" name="medProcedureId" value="${ medProcedure.id }"/> <c:out value="${ medProcedure.name }" /></td>
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



