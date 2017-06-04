<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="msg.adminSettingsTitle"/></title>
</head>
<body>

<jsp:include page="navbar.jsp"/>
<div class="mainBlock col-md-6 col-md-offset-3">
<h3><spring:message code="msg.adminSettingsH3"/></h3>
    <br/>
    <div class="col-md-8 col-md-offset-2">
<form method="POST" action="/admin/update_password" role="form">
    <input type="password" name="password" value="${user.password}" class="form-control" placeholder="<spring:message code="msg.adminSettingsNewPasswordPlaceholder"/>"/><br/>
    <input type="submit" value="<spring:message code="msg.adminSettingsUpdateButton"/>" class="btn btn-success"/>
</form>
    </div>
</div>
</body>
</html>
