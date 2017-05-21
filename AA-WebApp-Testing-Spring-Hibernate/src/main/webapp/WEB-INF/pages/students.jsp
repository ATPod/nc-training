<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Список студентов</title>
</head>
<body>
<div class="page-header" align="center"><h1>Список студентов</h1></div>
<div class="row">
    <div class="col-md-3" align="left">
        <jsp:include page="tutor_navbar.jsp"/>
    </div>
    <div class="col-md-8" align="center">
        <div class="row">
            <div class="col-md-4" align="center"><b>Имя студента</b></div>
            <div class="col-md-4" align="center"><b>Фамилия студента</b></div>
            <div class="col-md-3" align="center"><b>Количество набранных баллов</b></div>
        </div>
        <c:forEach var="student" items="${students}">
            <div class="row">
                <div class="col-md-4" align="center">${student.firstName}</div>
                <div class="col-md-4" align="center">${student.lastName}</div>
                <div class="col-md-3" align="center">${student.scores}</div>
            </div>
        </c:forEach>
    </div>
    </div>
</body>
</html>
