<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/pages/error.jsp" %>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<div class="page-header col-md-offset-1">
    <h1>Добро пожаловать в систему тестирования!</h1>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-1">
        <ul class="nav nav-list">
            <li>
                <a href="controller?command=GoToLogin"><h5><b>Войти <i class="glyphicon glyphicon-user"></i></b></h5>
                </a>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"><h5><b>Зарегистрироваться <i
                        class="glyphicon glyphicon-edit"></i></b></h5><span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="controller?command=GoToStudentRegistration">Регистрация студента</a></li>
                    <li class="divider"></li>
                    <li><a href="controller?command=GoToTutorRegistration">Регистрация тьютора</a></li>
                </ul>
            </li>
            <li>
                <a href=""><h5><b>О системе <i class="glyphicon glyphicon-info-sign"></i></b></h5></a>
            </li>
        </ul>
    </div>
    <div class="col-md-6">
        <img src="images/image.jpg" class="img-responsive">
    </div>
</div>
</body>
</html>
