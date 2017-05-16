<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<title><spring:message code="page.profile.student.title"/></title>
</head>
<html>
<body>
<div class="page-header" align="center"><h1><spring:message code="page.profile.student.title"/></h1></div>
<div class="col-md-3" align="left">
    <ul class="nav nav-list">
        <li><a href="${pageContext.request.contextPath}/home"><spring:message code="page.profile.student.menu.home"/></a></li>
        <li><a href="${pageContext.request.contextPath}/allTests"><spring:message code="page.profile.student.menu.tests"/></a></li>
        <li><a href="${pageContext.request.contextPath}/logout"><spring:message code="page.student.menu.logout"/></a></li>
    </ul>
</div>
<div align="left" class="col-md-8">
    <h5>
        <p><b><spring:message code="page.profile.student.name"/>: </b>${sessionUser.name}</p>
        <p><b><spring:message code="page.profile.student.surname"/>: </b>${sessionUser.surname}</p>
        <p><b><spring:message code="page.profile.student.scores"/>: </b>${sessionUser.scores}</p>
    </h5>
</div>
</body>
</html>