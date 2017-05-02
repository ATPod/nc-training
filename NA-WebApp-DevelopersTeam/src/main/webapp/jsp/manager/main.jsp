<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 19.04.2017
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Panel</title>
</head>
<body>
    <c:url var="showPendingTors" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="manager.showPendingTors" />
    </c:url>
    <c:url var="assignDevelopers" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="manager.main" />
    </c:url>

    <ul>
        <li><a href="${showPendingTors}">Show pending terms of reference</a></li>
        <li><a href="${assignDevelopers}">Assign developers</a></li>
    </ul>
</body>
</html>
