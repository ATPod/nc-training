<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
    <head>
        <title>SO-shop</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
    </head>
    <body>

    <sec:authorize access="hasRole('CLIENT')">
        <jsp:include page="client/navbar.jsp"/>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <jsp:include page="administrator/navbar.jsp"/>
    </sec:authorize>

    <div class="col-md-8 col-md-offset-2" style="margin-top: 5%">
        <img src="<c:url value="../../static/img/error.jpg"/>" style="margin: auto;">
    </div>
    </body>
</html>