<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<ul class="nav nav-list">
    <li><a href="${pageContext.request.contextPath}/allTests">Просмотреть список тестов</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Выйти из системы</a></li>
</ul>
</body>
</html>
