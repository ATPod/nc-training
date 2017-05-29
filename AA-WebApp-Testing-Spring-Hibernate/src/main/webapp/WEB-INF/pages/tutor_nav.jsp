<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="."><spring:message code="page.tutor.menu.home"/></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/createTest"><spring:message code="page.tutor.menu.test.create"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/allTests"><spring:message code="page.tutor.menu.tests"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/showStudents"><spring:message code="page.tutor.menu.students"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/tutorProfile"><spring:message code="page.tutor.menu.profile"/></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/logout"><spring:message code="page.tutor.menu.logout"/></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>
    </div>
</body>
</html>
