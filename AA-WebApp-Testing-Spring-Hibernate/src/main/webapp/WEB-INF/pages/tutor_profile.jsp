<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assets/css/navbar-fixed-side.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Профиль тьютора</title>
</head>
<body>
<jsp:include page="tutor_nav.jsp"/>
<div class="row">
<div class="page-header" align="center"><h1><spring:message code="page.profile.student.title"/></h1></div>
<div class="col-md-3 col-md-offset-1">
    <img src="${pageContext.request.contextPath}/assets/images/default_avatar.png" class="img-responsive">
</div>
<div align="left" class="col-md-8">
    <h5>
        ${sessionUser}
        <p><b><spring:message code="page.name"/>: </b>${sessionUser.name}</p>
        <p><b><spring:message code="page.surname"/>: </b>${sessionUser.surname}</p>
    </h5>
</div>
    </div>
</body>
</html>
