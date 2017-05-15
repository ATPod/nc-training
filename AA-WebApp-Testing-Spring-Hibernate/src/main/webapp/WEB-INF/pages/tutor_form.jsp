<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Регистрация тьютора</title>
</head>
<body>
<div align="center">
    <sf:form class="form-horizontal" name="tutorRegistration" method="POST"
             modelAttribute="newTutor" >
        <fieldset>
            <legend>Регистрация тьютора</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login" >Логин</label>
                <div class="col-md-4">
                    <sf:input id="login" name="login" type="text" value="" placeholder="Введите логин..."
                           class="form-control input-md" required="" path="login"/>
                    <span class="help-block"><sf:errors path="login" cssClass="text-danger"/></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <sf:input id="Password" name="password" type="password" value="12345" placeholder=""
                           class="form-control input-md" required="" path="password"/>
                   <span class="help-block"><sf:errors path="password" cssClass="text-danger"/></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Имя</label>
                <div class="col-md-4">
                    <sf:input id="name" name="name" type="text" value="" placeholder="Введите имя..."
                           class="form-control input-md" required="" path="firstName"/>
                    <span class="help-block"><sf:errors path="firstName" cssClass="text-danger"/></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="surname">Фамилия</label>
                <div class="col-md-4">
                    <sf:input id="surname" name="surname" type="text" value="" placeholder="Введите фамилию..."
                           class="form-control input-md" required="" path="lastName"/>
                    <span class="help-block"><sf:errors path="lastName" cssClass="text-danger"/></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="subject">Предмет</label>
                <div class="col-md-4">
                    <sf:input id="subject" placeholder="Введите предмет..."
                           class="form-control input-md" path="subject"/>
                    <span class="help-block"><sf:errors path="subject" cssClass="text-danger"/></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
                </div>
            </div>
        </fieldset>
    </sf:form>
</div>
</body>
</html>
