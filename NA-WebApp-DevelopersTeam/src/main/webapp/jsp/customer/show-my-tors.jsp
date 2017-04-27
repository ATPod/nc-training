<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean
        id="customerService"
        scope="application"
        class="by.training.nc.dev5.service.CustomerService" />

<html>
<head>
    <title>My terms of reference</title>
</head>
<body>
    <a href="controller?command=goHome">Back to main</a>
    <h2>My terms of reference</h2>

    <table>
        <c:forEach var="tor" items="${customerService.getTermsOfReference(sessionScope.user)}">
            <jsp:useBean
                    id="tor"
                    scope="page"
                    class="by.training.nc.dev5.entity.TermsOfReference" />
            <tr><th colspan="3">#${tor.id}</th></tr>
            <tr>
                <th>Specification</th>
                <th>Qualification</th>
                <th>Number of specialists</th>
            </tr>
            <c:forEach var="task" items="${tor.tasks}">
                <tr>
                    <td rowspan="${task.taskQuotas.size() + 1}">
                        ${task.specification}
                    </td>
                </tr>
                <c:forEach var="taskQuota" items="${task.taskQuotas}">
                    <tr>
                        <td>${taskQuota.qualification.name}</td>
                        <td>${taskQuota.developersNumber}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </table>
</body>
</html>
