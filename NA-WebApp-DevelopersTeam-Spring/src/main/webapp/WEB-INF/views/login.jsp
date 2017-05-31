<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <app:topNav/>

    <div class="container">
        <div class="text-center">
            <spring:url value="/j_spring_security_check" var="loginUrl"/>

            <form method="post" name="loginForm" action="${loginUrl}">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <div class="form-group">
                    <label>
                        User name:<br />
                        <input type="text" class="form-control" name="username"><br />
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        Password:<br />
                        <input type="password" class="form-control" name="password"><br />
                    </label>
                </div>
                <button class="btn btn-primary" type="submit">Submit</button>
                <button class="btn btn-default" type="reset">Reset</button>
                <p class="text-danger">
                    ${loginErrorMessage}
                </p>
            </form>
        </div>
    </div>
</body>
</html>
