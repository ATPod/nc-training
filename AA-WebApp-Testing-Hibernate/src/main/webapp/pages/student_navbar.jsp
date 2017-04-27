<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <title>Title</title>
</head>
<body>
<ul class="nav nav-list">
    <li><a href="controller?command=ShowTests">Просмотреть список тестов</a></li>
    <li><a href="controller?command=LogoutUser">Выйти из системы</a></li>
</ul>
</body>
</html>
