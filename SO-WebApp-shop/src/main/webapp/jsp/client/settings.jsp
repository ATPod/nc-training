<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Settings</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <h3>Update profile data</h3>
    <form method="POST" action="/client_update" role="form">
        <input type="hidden" name="command" value="client_update"/>
        <input type="text" name="c_firstname" pattern="^[a-zA-Z]+$" value="" class="form-control" placeholder="First name..."/><br/>
        <input type="text" name="c_lastname" pattern="^[a-zA-Z]+$" value="" class="form-control" placeholder="Last name..."/><br/>
        <input type="text" name="c_email" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" value="" class="form-control" placeholder="E-mail..."/><br/>
        <input type="text" name="password" value="" placeholder="Password..." class="form-control"/><br/>
        <input type="submit" value="Update" class="btn btn-success"/>
    </form>

        ${blackListMessage}
        ${errorMessage}

    </body>
</html>

