<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title><spring:message code="page.student.result.title"/></title>
</head>
<body>
<div class="page-header" align="center"><h1><spring:message code="page.student.result.title"/></h1></div>
        <jsp:include page="student_nav.jsp"/>
    <div class="col-md-12" align="center">
        <h1><spring:message code="page.student.result.result"/> ${result} <spring:message code="page.student.result.scores"/></h1>
        <h2><spring:message code="page.student.result.answers"/> ${questionAnswers}</h2>
    </div>
</body>
</html>
