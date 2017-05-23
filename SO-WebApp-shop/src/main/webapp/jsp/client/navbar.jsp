<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Client Navbar</title>
    <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <script src=<c:url value="http://code.jquery.com/jquery-latest.js"/>></script>
    <script src=<c:url value="../../static/js/bootstrap.min.js"/>></script>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">SO-shop</a>
            </div>
            <div class="navbar-collapse collapse" style="height: 1px;">
                <ul class="nav navbar-nav">
                    <li><a href="/client_catalog">Catalog</a></li>
                    <li><a href="/client_bag">Bag</a> </li>
                    <li><a href="/client_orderings">My orderings</a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${firstname} ${lastname}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="/client_settings">Settings</a></li>
                            <li><a href="/logout">Log out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</body>
</html>
