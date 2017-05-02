<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Пациенты</title>
</head>
<body>
<a href="controller?command=backtologin">Вход в систему</a>>
Выбор карточки пациента<br/>
<form name="choosePatientForm" method="POST" action="controller">
    <input type="hidden" name="command" value="choosePatient" />
    Выберите пациента:
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"> </td>
            <td align="center"><strong>ФИО</strong></td>
        </tr>
        <c:forEach var="patient" items="${patientsList}">
            <tr>
                <td><input type="radio" name="patientId" value="${ patient.id }"/></td>
                <td><c:out value="${ patient.name }" /></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Выбрать"/>  <br/>

    <c:if test="${userType=='DOCTOR'}">
        <a href="controller?command=gotoaddpatient">Добавить пациента</a> <br/>
    </c:if>
    ${operationMessage}<br />
</form>
</body>
</html>
