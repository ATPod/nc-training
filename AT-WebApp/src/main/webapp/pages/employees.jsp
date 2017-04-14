<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AT-WebApp</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
</div>
<div class="container">
    <fmt:setBundle basename="AT-WebApp-messages" var="ATWebApp"/>
    <h2>
        <fmt:message key="employee.title" bundle="${ATWebApp}"/>
    </h2>
    <c:forEach var="employee" items="${employees}">
    <div class="row">
        <div class="col-sm-4">
            <c:out value="${employee.id}"/>
        </div>
        <div class="col-sm-4">
            <c:out value="${employee.firstName}"/> <c:out value="${employee.lastName}"/>
        </div>
        <div class="col-sm-4">
            <c:out value="${employee.email}"/>
        </div>
    </div>
    </c:forEach>
</body>
</html>
