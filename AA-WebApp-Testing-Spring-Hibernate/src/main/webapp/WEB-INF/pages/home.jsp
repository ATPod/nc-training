<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Авторизация</title>
</head>
<body>
<div class="page-header col-md-offset-1">
    <h1><spring:message code="page.home.header"/></h1>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-1">
        <ul class="nav nav-list">
            <li>
                <a href="${pageContext.request.contextPath}/login"><h5><b><spring:message
                        code="page.home.menu.login"/><i class="glyphicon glyphicon-user"></i></b></h5>
                </a>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"><h5><b><spring:message
                        code="page.home.menu.registration"/> <i
                        class="glyphicon glyphicon-edit"></i></b></h5><span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/registerStudent"><spring:message
                            code="page.home.menu.registration.student"/> </a></li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/registerTutor"><spring:message
                            code="page.home.menu.registration.tutor"/> </a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"><h5><b><spring:message code="page.home.menu.language"/> <i
                        class="glyphicon glyphicon-cog"></i></b></h5><span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="?locale=ru"><spring:message code="page.home.menu.language.russian"/> </a></li>
                    <li class="divider"></li>
                    <li><a href="?locale=en"><spring:message code="page.home.menu.language.english"/> </a></li>
                    <li class="divider"></li>
                    <li><a href="?locale=be"><spring:message code="page.home.menu.language.belorussian"/></a></li>
                </ul>
            </li>
            <li>
                <a href=""><h5><b><spring:message code="page.home.menu.info"/> <i
                        class="glyphicon glyphicon-info-sign"></i></b></h5></a>
            </li>
        </ul>
    </div>
    <div class="col-md-6">
        <img src="../../assets/images/image.jpg" class="img-responsive">
    </div>
</div>
</body>
</html>

