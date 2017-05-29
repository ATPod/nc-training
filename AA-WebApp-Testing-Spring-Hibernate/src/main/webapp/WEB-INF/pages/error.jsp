<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title><spring:message code="page.error.title"/></title>
</head>
<body>
<div align="center">
    <h1><spring:message code="page.error.message"/></h1>
    ${errorMessage}
    <form action="${pageContext.request.contextPath}/home">
    <button id="singlebutton" name="singlebutton" class="btn btn-success"><spring:message code="page.error.ref"/></button>
</form>
</div>
</body>
</html>
