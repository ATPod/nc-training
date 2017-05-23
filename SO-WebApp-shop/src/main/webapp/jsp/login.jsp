<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

    <head>
        <title>SO-shop</title>
        <link href=<c:url value="../static/css/bootstrap.min.css"/> rel="stylesheet">
        <link href=<c:url value="../static/css/custom.css"/> rel="stylesheet">
    </head>

    <body>

        <div class="start-form">
            <h3>Welcome to<br>SO-shop</h3>
            <br>
            <form method="POST" action="/login" class="form-signin">
                <input type="text" name="userEmail" value="" placeholder="E-mail..." class="form-control"/><br/>
                <input type="password" name="userPassword" value="" placeholder="Password..." class="form-control"/><br/>
                <input type="submit" value="Log in" class="btn btn-primary start-btn"/>
            </form>

            <form method="GET" action="/registration">
                <input type="submit" value="Sign up"  class="btn btn-success start-btn"/>
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