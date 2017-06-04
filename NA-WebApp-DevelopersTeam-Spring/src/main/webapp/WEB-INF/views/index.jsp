<%@ page contentType="text/html"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>NA-DevelopersTeam</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <app:topNav/>

    <c:url var="login" value="/login" />
    <c:url var="home" value="/home" />

    <c:if test="${not empty sessionScope.user}">
        <%-- TODO: Is it MVC friendly? --%>
        <jsp:forward page="${home}" />
    </c:if>
    <div class="jumbotron text-center">
        <h1>Developers Team</h1>
        <p>A Modern Java Enterprise Application</p>
    </div>
    <div class="container">
        <div class="text-center">
            <a class="btn btn-primary" href="${login}">Log In</a>
        </div>
    </div>
</body>
</html>
