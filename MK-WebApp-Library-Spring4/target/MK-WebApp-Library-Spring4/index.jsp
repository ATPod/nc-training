<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>
<jsp:include page="pages/navbar.jsp"></jsp:include>
<c:choose>
    <c:when test="${user==null}">
        <jsp:forward page="pages/login.jsp"/>
    </c:when>
    <c:when test="${user!=null}">
        <jsp:forward page="pages/home.jsp"/>
    </c:when>
</c:choose>
<div class="row row-offset-4"><h1>START PAGE</h1></div>
</body>
</html>