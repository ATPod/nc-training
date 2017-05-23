<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Выбор действия</title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../views/elements/header.jsp" %>
        </div>
        <a href="/index">Вход в систему</a>>
        <a href="/choosepatient">Выбор карточки пациента</a>>
        Карточка пациента<br/>
        <div align="center">
            <strong>Карточка пациента "${patientName}"</strong>
            <table align="center">
                <tr>
                    <td valign="top" style="text-align: center">
                        <a href="/adddiagnosis">Добавить диагноз</a> <br/>
                        <form name="diagnosisListForm" method="POST" action="/deldiagnosis">
                            <input type="submit" value="Удалить диагноз"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong>Диагнозы</strong></td>
                                </tr>
                                <c:if test="${empty diagnosisesList}">
                                    <tr>
                                        <td>Нет записей</td>
                                    </tr>
                                </c:if>
                                <c:forEach var="diagnosis" items="${diagnosisesList}">
                                    <tr>
                                        <td><input type="radio" name="diagnosisId" value="${ diagnosis.id }"/> <c:out value="${ diagnosis.name }" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </td>
                    <td valign="top" style="text-align: center">
                        <a href="/adddrug">Добавить лекарство</a> <br/>
                        <form name="drugListForm" method="POST" action="/deldrug">
                            <input type="submit" value="Удалить лекарство" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong>Лекарства</strong></td>
                                </tr>
                                <c:if test="${empty drugsList}">
                                    <tr>
                                        <td>Нет записей</td>
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
                        <a href="/addmedprocedure">Добавить процедуру</a> <br/>
                        <form name="medProcedureListForm" method="POST" action="/delmedprocedure">
                            <input type="submit" value="Удалить процедуру" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong>Процедуры</strong></td>
                                </tr>
                                <c:if test="${empty medProceduresList}">
                                    <tr>
                                        <td>Нет записей</td>
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
                    <td valign="top" style="text-align: center">
                        <a href="/addsurgery">Добавить операцию</a> <br/>
                        <form name="surgeryListForm" method="POST" action="/delsurgery">
                            <input type="submit" value="Удалить операцию" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong>Операции</strong></td>
                                </tr>
                                <c:if test="${empty surgeriesList}">
                                    <tr>
                                        <td>Нет записей</td>
                                    </tr>
                                </c:if>
                                <c:forEach var="surgery" items="${surgeriesList}">
                                    <tr>
                                        <td><input type="radio" name="surgeryId" value="${ surgery.id }"/> <c:out value="${ surgery.name }" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
            <div align="center">
                <form method="POST" action="/delpatient" >
                    <input type="submit" value="Удалить карточку пациента"/>
                </form>
            </div>
            ${operationMessage}  <br />
        </div>
        <div class="footer" align="center">
            <%@include file="../../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>

