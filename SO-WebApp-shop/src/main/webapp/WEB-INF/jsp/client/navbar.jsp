<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>SO-shop</title>
    <script src=<c:url value="../../../static/js/jquery-3.2.1.min.js"/>></script>
    <link href=<c:url value="../../../static/css/bootstrap.min.css"/> rel="stylesheet">>
    <link href=<c:url value="../../../static/css/client-style.css"/> rel="stylesheet">>
    <script src=<c:url value="../../../static/js/bootstrap.min.js"/>></script>
</head>
<body>
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <span class="navbar-brand" style="font-family: Lobster; font-size: 27px;">SO-shop</span>
            </div>
            <div class="navbar-collapse collapse" style="height: 1px;">
                <ul class="nav navbar-nav">
                    <li><a href="/client/catalog"><spring:message code="msg.clientNavbarCatalog"/></a></li>
                    <li><a href="/client/bag"><spring:message code="msg.clientNavbarBag"/></a> </li>
                    <li><a href="/client/orderings"><spring:message code="msg.clientNavbarMyOrdering"/></a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.firstname} ${user.lastname}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/client/settings"><spring:message code="msg.clientNavbarSetting"/></a></li>
                            <li><a href="/logout"><spring:message code="msg.clientNavbarLogOut"/></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="msg.language"/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=en_US">English</a></li>
                            <li><a href="?lang=ru_RU">Русский</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>
