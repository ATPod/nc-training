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
            <form method="POST" action="controller">
                <input type="hidden" name="command" value="gotoadddiagnosis"/>
                <input type="submit" value="Поставить диагноз"/>
            </form>
            <form name="diagnosisListForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delDiagnosis" />
                <input type="submit" value="Снять диагноз"/>  <br/>
                <table align="center" border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Диагнозы</strong></td>
                    </tr>
                    <c:if test="${empty diagnosisesList}">
                        <tr>
                            <td>Нет записей.</td>
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
            <form method="POST" action="controller">
                <input type="hidden" name="command" value="gotoadddrug"/>
                <input type="submit" value="Прописать лекарство" align="center"/>
            </form>
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
            <form method="POST" action="controller">
                <input type="hidden" name="command" value="gotoaddmedprocedure" />
                <input type="submit" value="Назначить процедуру" align="center" />
            </form>
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
        <td valign="top" style="text-align: center">
            <form method="POST" action="controller">
                <input type="hidden" name="command" value="gotoaddsurgery" />
                <input type="submit" value="Назначить операцию" align="center"/>
            </form>
            <form name="surgeryListForm" method="POST" action="controller">
                <input type="hidden" name="command" value="delSurgery" />
                <input type="submit" value="Сделать операцию" align="center"/>  <br/>
                <table align="center" border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"><strong>Операции</strong></td>
                    </tr>
                    <c:if test="${empty surgeriesList}">
                        <tr>
                            <td>Нет записей.</td>
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
<a href="controller?command=delpatient">Выписать пациента (удалить карточку)</a><br/>
<a href="controller?command=backtochoosepatient">Вернуться к выбору пациента</a><br/>
<a href="controller?command=backtologin">Выйти из системы</a><br/>
${operationMessage}  <br />
</body>
</html>

