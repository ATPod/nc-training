<%@ page contentType="text/html"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<header>
    <c:if test="${not empty sessionScope.user}">
        <jsp:useBean
                id="user"
                scope="session"
                type="by.training.nc.dev5.entity.Person" />
        <span>Logged in as ${user.name}</span>
        <span><a href="controller?command=logout">Log out</a></span>
        <span><a href="controller?command=routeHome">Home</a></span>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <span><a href="controller?command=goLogin">Log in</a></span>
    </c:if>
</header>

<h2>Hello World!</h2>



</body>
</html>
