<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer panel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="/jsp/nav.jspf" %>

    <c:url var="showMyTors" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="home" />
        <c:param name="view" value="customer.showMyTors" />
    </c:url>
    <c:url var="createTor" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="home" />
        <c:param name="view" value="customer.createTor" />
    </c:url>

    <div class="row">
        <div class="col-lg-3">
            <div class="panel panel-default">
                <ul class="nav">
                    <li><a href="${showMyTors}">Show my terms of reference</a></li>
                    <li><a href="${createTor}">Create new terms of reference</a></li>
                </ul>
            </div>
        </div>
        <div class="col-lg-9">
            <jsp:useBean
                    id="router"
                    scope="application"
                    class="by.training.nc.dev5.web.routing.Router" />

            <c:if test="${not empty param.view}">
                <c:url var="incl" value="${router.resolvePath(param.view)}" />
                <jsp:include page="${incl}" />
            </c:if>
        </div>
    </div>
</body>
</html>
