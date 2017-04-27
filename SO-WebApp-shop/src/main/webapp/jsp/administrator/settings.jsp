<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Settings</title>
</head>
<body>

${name} <br/><br/>
<a href="controller?command=admin_go_to_clients">Clients</a> <br/>
<a href="controller?command=admin_go_to_products">Products</a> <br/>
<a href="controller?command=admin_go_to_orderings">Orderings</a> <br/>
<a href="controller?command=logout">Log out</a> <br/><br/>

<form name="passwordForm" method="POST" action="controller">
    <input type="hidden" name="command" value="admin_update_password"/>
    Password:<br/>
    <input type="text" name="password" value=""/><br/>
    <input type="submit" value="Update"/>
</form>

${errorMessage}
</body>
</html>
