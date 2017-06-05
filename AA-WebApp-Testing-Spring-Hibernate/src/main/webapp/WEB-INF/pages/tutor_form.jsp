<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/validator.min.js"></script>
    <title><spring:message code="page.registration.tutor.title"/></title>
</head>
<body>
<div align="center">
    <sf:form class="form-horizontal" name="tutorRegistration" method="POST"
             modelAttribute="newTutor" role="form" data-toggle="validator">
        <fieldset>
            <legend><spring:message code="page.registration.tutor.title"/></legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login" ><spring:message code="page.login"/></label>
                <div class="col-md-4">
                    <spring:message code="page.input.login.placeholder" var="login_placeholder"/>
                    <sf:input id="login" name="login" type="text" value="" placeholder="${login_placeholder}"
                           class="form-control input-md" required="required" path="login" data-minlength="6"
                              data-error="Логин не менее 6 символов"
                    />
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password"><spring:message code="page.password"/></label>
                <div class="col-md-4">
                    <sf:input id="Password" name="password" type="password" value="12345" placeholder=""
                           class="form-control input-md" required="required" path="password" data-minlength="6"
                              data-error="Пароль не менее 6 символов"/>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name"><spring:message code="page.name"/></label>
                <div class="col-md-4">
                    <spring:message code="page.input.name.placeholder" var="name_placeholder"/>
                    <sf:input id="name" name="name" type="text" value="" placeholder="${name_placeholder}"
                           class="form-control input-md" required="required" path="firstName"
                              pattern="[A-Za-zА-яа-я]+"
                              data-minlength="1"
                              data-error="Имя должно иметь длину более одного символа и состоять из букв"/>
                    <!--<span class="help-block">error</span>-->
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="surname"><spring:message code="page.surname"/></label>
                <spring:message code="page.input.name.placeholder" var="surname_placeholder"/>
                <div class="col-md-4">
                    <sf:input id="surname" name="surname" type="text" value="" placeholder="${surname_placeholder}"
                           class="form-control input-md" required="required" path="lastName"
                              pattern="[A-Za-zА-яа-я]+"
                              data-minlength="1"
                              data-error="Фамилия должна иметь длину более одного символа и состоять из букв"/>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="subject"><spring:message code="page.registration.tutor.input.subject"/></label>
                <div class="col-md-4">
                    <spring:message code="page.registration.tutor.input.subject.placeholder" var="subject_placeholder"/>
                    <sf:input id="subject" placeholder="${subject_placeholder}"
                           class="form-control input-md" path="subject" required="required"
                              pattern="[A-Za-zА-яа-я]+"
                              data-minlength="1"
                              data-error="Название предмета должно иметь длину более одного символа и состоять из букв"
                    />
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success"><spring:message code="page.registration.button"/></button>
                </div>
            </div>
        </fieldset>
    </sf:form>
</div>
</body>
</html>
