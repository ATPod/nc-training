<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title><s:message code="add.surgery.title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../../views/elements/header.jsp" %>
        </div>
        <a href="/index"><s:message code="index.title"/></a>>
        <a href="/choosepatient"><s:message code="patients.title"/></a>>
        <a href="/doctormenu"><s:message code="menu.title"/></a>><s:message code="add.surgery.title"/><br/>
        <div align="center">
            <form name="addSurgeryForm" method="POST" action="/addsurgery">
                <s:message code="add.prescribing.entername"/><br />
                <input type="text" name="surgeryName" value="" />
                <s:message var="button" code="common.submit"/>
                <input type="submit" value="${button}" /> <br />
                ${operationMessage}  <br />
            </form>
        </div>
        <div class="footer" align="center">
            <%@include file="../../../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>
