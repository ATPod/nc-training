<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="${pageContext.request.contextPath}  /assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>
<html>
<body>
<div class="page-header" align="center"><h1>Профиль студента</h1></div>
<div class="col-md-3" align="left">
    <ul class="nav nav-list">
        <li><a href="${pageContext.request.contextPath}/allTests">Просмотреть список тестов</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Выйти из системы</a></li>
    </ul>
</div>
<div align="left" class="col-md-8">
    <h5>
        <p><b>Имя: </b>${sessionUser.name}</p>
        <p><b>Фамилия: </b>${sessionUser.surname}</p>
        <p><b>Набранные баллы: </b>${sessionUser.scores}</p>
    </h5>
</div>
</body>
</html>