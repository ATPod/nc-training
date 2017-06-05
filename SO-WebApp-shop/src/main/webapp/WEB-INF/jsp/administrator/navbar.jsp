<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Admin Navbar</title>
    <script src=<c:url value="../../../static/js/jquery-3.2.1.min.js"/>></script>
    <link href=<c:url value="../../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <link href=<c:url value="../../../static/css/admin-style.css"/> rel="stylesheet">
    <script src=<c:url value="../../../static/js/bootstrap.min.js"/>></script>
</head>
<body>
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">SO-shop</a>
            </div>
            <div class="navbar-collapse collapse" style="height: 1px;">
                <ul class="nav navbar-nav">
                    <li><a href="/admin/clients"><spring:message code="msg.adminNavbarClients"/></a></li>
                    <li><a href="/admin/orderings"><spring:message code="msg.adminNavbarOrderings"/></a> </li>
                    <li><a href="/admin/products"><spring:message code="msg.adminNavbarProducts"/></a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.name}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/settings"><spring:message code="msg.adminNavbarSettings"/></a></li>
                            <li><a href="/logout"><spring:message code="msg.adminNavbarLogout"/></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="msg.language"/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}?lang=en_US">English</a></li>
                            <li><a href="${pageContext.request.contextPath}?lang=ru_RU">Русский</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
