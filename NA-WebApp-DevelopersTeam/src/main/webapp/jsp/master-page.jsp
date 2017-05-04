<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 04.05.2017
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean
        id="router"
        scope="application"
        class="by.training.nc.dev5.web.routing.Router" />

<html>
<head>
    <title>Panel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="/jsp/nav.jspf" %>

    <div class="row">
        <div class="col-lg-3">
            <div class="panel panel-default">
                <c:if test="${not empty sessionScope.sidenavUri}">
                    <jsp:include page="${sessionScope.sidenavUri}" />
                </c:if>
            </div>
        </div>
        <div class="col-lg-9">
            <c:if test="${not empty requestScope.view}">
                <jsp:include page="${router.resolvePath(requestScope.view)}" />
            </c:if>
        </div>
    </div>
</body>
</html>
