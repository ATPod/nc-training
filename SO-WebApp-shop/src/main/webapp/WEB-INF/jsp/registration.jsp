<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

    <head>
        <title>SO-shop</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
        <link href=<c:url value="../../static/css/start-style.css"/> rel="stylesheet">
    </head>

    <body>

        <div class="start-form">
            <h3><spring:message code="msg.registrationH"/></h3>
            <br>
            <form method="POST" action="/register" class="form-signin">
                <input type="text" name="userFirstName" placeholder="<spring:message code="msg.registrationFirstNamePlaceholder"/>" class="form-control" value=""/><br/>
                <input type="text" name="userLastName" placeholder="<spring:message code="msg.registrationLastNamePlaceholder"/>" class="form-control" value=""/><br/>
                <input type="text" name="userEmail" value="" placeholder="<spring:message code="msg.registrationEmailPlaceholder"/>" class="form-control"/><br/>
                <input type="password" name="userPassword" value="" placeholder="<spring:message code="msg.registrationPasswordPlaceholder"/>" class="form-control"/><br/>
                <input type="submit" value="<spring:message code="msg.registrationSignUpInput"/>"  class="btn btn-success start-btn"/>
            </form>
        </div>

        <c:if test="${errorMessage != null}">
        <c:if test="${!errorMessage.isEmpty()}">
            <div class="alert-danger start-alert">
                    ${errorMessage}
            </div>
        </c:if>
        </c:if>

    </body>
</html>
