<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

    <head>
        <title>SO-shop</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
        <link href=<c:url value="../../static/css/start-style.css"/> rel="stylesheet">
    </head>

    <body>

        <div class="start-form">
            <h3><spring:message code="msg.welcome"/><br><span style="font-family:Lobster;">SO-shop</span></h3>
            <br>
            <c:url value="/j_spring_security_check" var="loginUrl" />
            <form method="POST" action="${loginUrl}" class="form-signin">
                <input type="text" name="j_username" value="" placeholder="<spring:message code="msg.placeholder.email"/>" class="form-control"/><br/>
                <input type="password" name="j_password" value="" placeholder="<spring:message code="msg.placeholder.password"/>" class="form-control"/><br/>
                <input type="submit" value="<spring:message code="msg.login"/>" class="btn btn-primary start-btn"/>
            </form>

            <form method="GET" action="/registration">
                <input type="submit" value="<spring:message code="msg.signup"/>"  class="btn btn-success start-btn"/>
            </form>
            <a href="/login?lang=en_US">EN</a> | <a href="/login?lang=ru_RU">RU</a>
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