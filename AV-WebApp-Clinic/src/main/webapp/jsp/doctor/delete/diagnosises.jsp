<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Диагнозы</title>
</head>
<body>
<form name="chooseDiagnosisForm" method="POST" action="controller">
    <input type="hidden" name="command" value="delDiagnosis" />
    Выберите диагноз:
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"> </td>
            <td align="center"><strong>Диагноз</strong></td>
        </tr>
        <c:forEach var="diagnosis" items="${diagnosisesList}">
            <tr>
                <td><input type="radio" name="diagnosisId" value="${ diagnosis.id }"/></td>
                <td><c:out value="${ diagnosis.name }" /></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Выбрать"/>  <br/>
    <a href="controller?command=backtoinnermenu">Вернуться обратно</a><br/>
    <a href="controller?command=logout">Выйти из системы</a><br/><br/>
    ${operationMessage}  <br />
    ${errorEmptyChoice}<br />
    ${errorEmptyList} <br/>
</form>
</body>
</html>

