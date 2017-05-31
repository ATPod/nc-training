<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><s:message code="patients.title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../views/elements/header.jsp" %>
        </div>
        <a href="/index"><s:message code="index.title"/></a>>
        <s:message code="patients.title"/><br/>
        <div align="center">
            <form name="choosePatientForm" method="POST" action="/choosepatient">
                <s:message code="patients.choosepatientcard"/>
                <table border="1">
                    <tr bgcolor="#CCCCCC">
                        <td align="center"> </td>
                        <td align="center"><strong><s:message code="patients.fullname"/></strong></td>
                    </tr>
                    <c:if test="${empty patientsList}">
                        <tr>
                            <td></td>
                            <td><s:message code="common.emptylist"/></td>
                        </tr>
                    </c:if>
                    <c:forEach var="patient" items="${patientsList}">
                        <tr>
                            <td><input type="radio" name="patientId" value="${ patient.id }"/></td>
                            <td><c:out value="${ patient.name }" /></td>
                        </tr>
                    </c:forEach>
                </table>
                <s:message var="button" code="common.submit"/>
                <input type="submit" value="${button}"/>  <br/>
                <c:if test="${userType=='DOCTOR'}">
                    <a href="/addpatient"><s:message code="add.patient.title"/></a> <br/>
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
