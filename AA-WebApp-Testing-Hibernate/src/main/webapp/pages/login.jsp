<!--Директива JSP page, данная директива предоставляет атрибуты для JSP страницы-->
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/pages/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <title>Авторизация</title>
</head>
<body>
<div align="center">
    <font color="#8b0000"><b>${error_message}</b></font>
    <form class="form-horizontal" name="loginForm" method="POST" action="controller?command=Login">
        <input type="hidden" name="command" value="Login"/>
        <fieldset>
            <legend>Вход в систему</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="" placeholder="Введите логин..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <input id="Password" name="password" type="password" value="12345" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>

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
