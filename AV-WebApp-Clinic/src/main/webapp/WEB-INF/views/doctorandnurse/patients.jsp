<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Пациенты</title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../views/elements/header.jsp" %>
        </div>
        <a href="/index">Вход в систему</a>>
        Выбор карточки пациента<br/>
        <div align="center">
            <form name="choosePatientForm" method="POST" action="/choosepatient">
                Выберите пациента:
                <table border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"> </td>
                        <td align="center"><strong>ФИО</strong></td>
                    </tr>
                    <c:if test="${empty patientsList}">
                        <tr>
                            <td></td>
                            <td>Нет записей</td>
                        </tr>
                    </c:if>
                    <c:forEach var="patient" items="${patientsList}">
                        <tr>
                            <td><input type="radio" name="patientId" value="${ patient.id }"/></td>
                            <td><c:out value="${ patient.name }" /></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="submit" value="Выбрать"/>  <br/>
                <c:if test="${userType=='DOCTOR'}">
                    <a href="/addpatient">Добавить пациента</a> <br/>
                </c:if>
            </form>
            ${operationMessage}<br />
        </div>
        <div class="footer" align="center">
            <%@include file="../../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>
