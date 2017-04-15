<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
</div>
<div class="container">
    <fmt:setBundle basename="AT-WebApp-messages" var="ATWebApp"/>
    <form action="EmployeeController" method="post">
        <div class="row">
            <div class="col-md-4">
                <fmt:message key="index.user.title" bundle="${ATWebApp}"/> :
            </div>
            <div class="col-md-4">
                <input type="text" name="username">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <fmt:message key="index.user.password" bundle="${ATWebApp}"/> :
            </div>
            <div class="col-md-4">
                <input type="password" name="password">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="<fmt:message key='index.button.login' bundle='${ATWebApp}'/>"/>
        </div>
    </form>
</body>
</html>
