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
<h3>Update password</h3>
<form method="POST" action="/admin_update_password" role="form">
    <input type="hidden" name="command" value="admin_update_password"/>
    <input type="password" name="password" value="" class="form-control" placeholder="New password..."/><br/>
    <input type="submit" value="Update" class="btn btn-success"/>
</form>

${errorMessage}
</body>
</html>
