<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Процедуры</title>
</head>
<body>
<form name="chooseProcedureForm" method="POST" action="controller">
    <input type="hidden" name="command" value="delProcedure" />
    Выберите процедуру:
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"> </td>
            <td align="center"><strong>Процедура</strong></td>
        </tr>
        <c:forEach var="procedure" items="${proceduresList}">
            <tr>
                <td><input type="radio" name="procedureId" value="${ procedure.id }"/></td>
                <td><c:out value="${ procedure.name }" /></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Выбрать"/>  <br/>
    <a href="controller?command=backtomenu">Вернуться обратно</a><br/>
    <a href="controller?command=backtologin">Выйти из системы</a><br/><br/>
    ${operationMessage}  <br />
</form>
</body>
</html>
