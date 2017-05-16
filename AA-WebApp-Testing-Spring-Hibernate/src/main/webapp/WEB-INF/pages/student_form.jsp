<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title><spring:message code="page.registration.student.title"/></title>
</head>
<body>
<div align="center">
    <sf:form class="form-horizontal" name="studentRegistration" method="POST" modelAttribute="newStudent">
        <fieldset>
            <legend><spring:message code="page.registration.student.title"/></legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login"><spring:message code="page.registration.input.login"/></label>
                <div class="col-md-4">
                    <spring:message code="page.registration.input.login" var="login_placeholder"/>
                    <sf:input id="login" name="login" type="text" value="" placeholder="${login_placeholder}"
                              class="form-control input-md" required="" path="login"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password"><spring:message code="page.registration.input.password"/></label>
                <div class="col-md-4">
                    <sf:input id="Password" name="password" type="password" value="12345" placeholder=""
                              class="form-control input-md" required="" path="password"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name"><spring:message code="page.registration.input.name"/></label>
                <div class="col-md-4">
                    <spring:message code="page.registration.input.name.placeholder" var="name_placeholder"/>
                    <sf:input id="name" name="name" type="text" value="" placeholder="${name_placeholder}"
                              class="form-control input-md" required="" path="firstName"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name"><spring:message code="page.registration.input.surname"/></label>
                <div class="col-md-4">
                    <spring:message code="page.registration.input.surname.placeholder" var="surname_placeholder"/>
                    <sf:input id="surname" name="surname" type="text" value="" placeholder="${surname_placeholder}"
                              class="form-control input-md" required="" path="lastName"/>
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
