<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><s:message code="menu.title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../views/elements/header.jsp" %>
        </div>
        <a href="/index"><s:message code="index.title"/></a>>
        <a href="/choosepatient"><s:message code="patients.title"/></a>>
        <s:message code="menu.title"/><br/>
        <div align="center">
            <strong>"${patientName}"</strong>
            <table align="center">
                <tr>
                    <td valign="top" style="text-align: center">
                        <a href="/adddiagnosis"><s:message code="add.diagnosis.title"/></a> <br/>
                        <form name="diagnosisListForm" method="POST" action="/deldiagnosis">
                            <s:message var="button" code="menu.deldiagnosis"/>
                            <input type="submit" value="${button}"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong><s:message code="menu.diagonisises"/></strong></td>
                                </tr>
                                <c:if test="${empty diagnosisesList}">
                                    <tr>
                                        <td><s:message code="common.emptylist"/></td>
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
                        <a href="/adddrug"><s:message code="add.drug.title"/></a> <br/>
                        <form name="drugListForm" method="POST" action="/deldrug">
                            <s:message var="button" code="menu.deldrug"/>
                            <input type="submit" value="${button}" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong><s:message code="menu.drugs"/></strong></td>
                                </tr>
                                <c:if test="${empty drugsList}">
                                    <tr>
                                        <td><s:message code="common.emptylist"/></td>
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
                        <a href="/addmedprocedure"><s:message code="add.medprocedure.title"/></a> <br/>
                        <form name="medProcedureListForm" method="POST" action="/delmedprocedure">
                            <s:message var="button" code="menu.delmedprocedure"/>
                            <input type="submit" value="${button}" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong><s:message code="menu.medprocedures"/></strong></td>
                                </tr>
                                <c:if test="${empty medProceduresList}">
                                    <tr>
                                        <td><s:message code="common.emptylist"/></td>
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
                        <a href="/addsurgery"><s:message code="add.surgery.title"/></a> <br/>
                        <form name="surgeryListForm" method="POST" action="/delsurgery">
                            <s:message var="button" code="menu.delsurgery"/>
                            <input type="submit" value="${button}" align="center"/>  <br/>
                            <table align="center" border="1">
                                <tr bgcolor="#CCCCCC">
                                    <td align="center"><strong><s:message code="menu.surgeries"/></strong></td>
                                </tr>
                                <c:if test="${empty surgeriesList}">
                                    <tr>
                                        <td><s:message code="common.emptylist"/></td>
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
                    <s:message var="button" code="menu.delpatient"/>
                    <input type="submit" value="${button}"/>
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

