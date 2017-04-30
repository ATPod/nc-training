<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer panel</title>
</head>
<body>
    <c:url var="showMyTors" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="customer.showMyTors" />
    </c:url>
    <c:url var="createTor" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="customer.createTor" />
    </c:url>

    <h2>Customer panel</h2>

    <ul>
        <li><a href="${showMyTors}">Show my terms of reference</a></li>
        <li><a href="${createTor}">Create new terms of reference</a></li>
    </ul>
</body>
</html>
