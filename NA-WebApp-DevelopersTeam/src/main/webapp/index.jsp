<%@ page contentType="text/html"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <c:url var="login" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="login" />
    </c:url>
    <c:url var="logout" value="controller">
        <c:param name="command" value="logout" />
    </c:url>
    <c:url var="home" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="home" />
    </c:url>

    <%--<header>--%>
        <%--<c:if test="${not empty sessionScope.user}">--%>
            <%--<jsp:useBean--%>
                    <%--id="user"--%>
                    <%--scope="session"--%>
                    <%--type="by.training.nc.dev5.entity.Person" />--%>
            <%--<span>Logged in as ${user.name}</span>--%>
            <%--<span><a href="${logout}">Log out</a></span>--%>
            <%--<span><a href="${home}">Home</a></span>--%>
        <%--</c:if>--%>
        <%--<c:if test="${empty sessionScope.user}">--%>
            <%--<span><a href="${login}">Log in</a></span>--%>
        <%--</c:if>--%>
    <%--</header>--%>
    <%--<h2>NA-DevelopersTeam</h2>--%>

    <c:if test="${not empty sessionScope.user}">
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
