<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>

<jsp:useBean
        id="customerService"
        scope="application"
        class="by.training.nc.dev5.service.CustomerService" />

<html>
<head>
    <title>My terms of reference</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h2>My terms of reference</h2>

    <%--<table>--%>
        <%--<c:forEach var="tor" items="${customerService.getTermsOfReference(sessionScope.user)}">--%>
            <%--<jsp:useBean--%>
                    <%--id="tor"--%>
                    <%--scope="page"--%>
                    <%--class="by.training.nc.dev5.entity.TermsOfReference" />--%>
            <%--<tr><th colspan="3">#${tor.id}</th></tr>--%>
            <%--<tr>--%>
                <%--<th>Specification</th>--%>
                <%--<th>Qualification</th>--%>
                <%--<th>Number of specialists</th>--%>
            <%--</tr>--%>
            <%--<c:forEach var="task" items="${tor.tasks}">--%>
                <%--<tr>--%>
                    <%--<td rowspan="${task.taskQuotas.size() + 1}">--%>
                        <%--${task.specification}--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<c:forEach var="taskQuota" items="${task.taskQuotas}">--%>
                    <%--<tr>--%>
                        <%--<td>${taskQuota.qualification.name}</td>--%>
                        <%--<td>${taskQuota.developersNumber}</td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</c:forEach>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
    <div class="container">
        <table class="table">
            <c:forEach var="tor" items="${customerService.getTermsOfReference(sessionScope.user)}">
                <app:tor tor="${tor}" />
            </c:forEach>
        </table>
    </div>
</body>
</html>
