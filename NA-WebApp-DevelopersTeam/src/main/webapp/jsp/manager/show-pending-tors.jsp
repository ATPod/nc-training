<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean
        id="managerService"
        scope="application"
        class="by.training.nc.dev5.service.ManagerService" />

<html>
<head>
    <title>Pending Terms of Reference</title>
</head>
<body>
    <h2>Pending Terms of Reference</h2>


    <table>
        <c:forEach var="tor" items="${managerService.pendingTermsOfReference}">
            <tr><th colspan="3">#${tor.id}</th></tr>
            <tr>
                <td>
                    <form method="post" action="controller">
                        <input type="hidden" name="command" value="createProject">
                        <input type="hidden" name="torId" value="${tor.id}">
                        <button type="submit">
                            Create project
                        </button>
                    </form>
                </td>
                <th>Specification</th>
                <th>Qualification</th>
                <th>Number of specialists</th>
            </tr>
            <c:forEach var="task" items="${tor.tasks}">
                <tr>
                    <td colspan="2" rowspan="${task.taskQuotas.size() + 1}">
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
