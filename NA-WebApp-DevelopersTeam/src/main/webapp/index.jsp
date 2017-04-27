<%@ page contentType="text/html"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
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

<header>
    <c:if test="${not empty sessionScope.user}">
        <jsp:useBean
                id="user"
                scope="session"
                type="by.training.nc.dev5.entity.Person" />
        <span>Logged in as ${user.name}</span>
        <span><a href="${logout}">Log out</a></span>
        <span><a href="${home}">Home</a></span>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <span><a href="${login}">Log in</a></span>
    </c:if>
</header>

<h2>NA-DevelopersTeam</h2>

</body>
</html>
