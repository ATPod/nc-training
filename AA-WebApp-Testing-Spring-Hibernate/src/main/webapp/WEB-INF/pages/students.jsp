<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title><spring:message code="page.students.title"/></title>
</head>
<body>
<jsp:include page="tutor_nav.jsp"/>
<div class="page-header" align="center"><h1><spring:message code="page.students.title"/></h1></div>
<div class="col-md-12" align="center">
    <div class="row">
        <div class="col-md-4" align="center"><b><spring:message code="page.students.student.name"/></b></div>
        <div class="col-md-4" align="center"><b><spring:message code="page.students.student.surname"/></b></div>
        <div class="col-md-3" align="center"><b><spring:message code="page.students.student.scores"/></b></div>
    </div>
    <c:forEach var="student" items="${students}">
        <div class="row">
            <div class="col-md-4" align="center">${student.firstName}</div>
            <div class="col-md-4" align="center">${student.lastName}</div>
            <div class="col-md-3" align="center">${student.scores}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
