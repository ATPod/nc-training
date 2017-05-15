<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Авторизация</title>
</head>
<body>
<!--Путь к фильтру аутентификации-->
<spring:url value="/j_spring_security_check" var="loginUrl" />
<div align="center">
    <form class="form-horizontal" name="loginForm" method="POST" action="${loginUrl}">
        <fieldset>
            <legend>Вход в систему</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="j_username" type="text" value="" placeholder="Введите логин..."
                              class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <input id="Password" name="j_password" type="password" value="12345" placeholder=""
                              class="form-control input-md" required="">
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
