<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%@ taglib
        prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean
        id="customerService"
        scope="application"
        class="by.training.nc.dev5.service.CustomerService" />
<jsp:useBean
        id="helpService"
        scope="application"
        class="by.training.nc.dev5.service.HelpService" />
<jsp:useBean
        id="torBuilder"
        scope="session"
        class="by.training.nc.dev5.service.TermsOfReferenceBuilder" />
<html>
<head>
    <title>Create Terms of Reference</title>
</head>
<body>
    <c:url var="home" value="controller">
        <c:param name="command" value="go" />
        <c:param name="location" value="home" />
    </c:url>

    <a href="${home}">Back to main</a><br />
    <form name="taskControlForm" method="post" action="controller">
        <input type="hidden" name="command" value="removeTask">

        <input type="submit" value="Delete selected">
        <table>
            <tr><td></td><td>Specification</td><td>Developers</td></tr>
            <c:forEach var="task" varStatus="i" items="${torBuilder.tasks}">
                <tr>
                    <td>
                    <td rowspan="2">
                        <input
                            type="checkbox"
                            name="task"
                            value="${i.index}">
                    </td>
                    <td rowspan="${task.taskQuotas.size() + 1}">
                        ${task.specification}
                    </td>
                </tr>
                <tr>
                    <c:forEach var="taskQuota" items="${task.taskQuotas}">
                        <td>${taskQuota.qualification.name}</td>
                        <td>${taskQuota.developersNumber}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </form>
    <hr>
    <form method="post" name="addTask" action="controller">
        <input type="hidden" name="command" value="addTask">

        <label>
            Specification:<br />
            <textarea name="specification" required></textarea>
        </label><br />

        <label>
            Qualification:<br />
            <select name="qualificationId" required>
                <c:forEach
                        var="qualification"
                        items="${helpService.qualifications}">

                    <option value="${qualification.id}">
                        ${qualification.name}
                    </option>
                </c:forEach>
            </select>
        </label>
        <br />

        <label>
            Developers number:<br />
            <input type="number" name="developersNumber" required>
        </label><br />

        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
    <form name="createTor" method="post" action="controller">
        <input type="hidden" name="command" value="createTor">
        <input
                type="submit"
                <c:if test="${empty torBuilder.tasks}">
                    disabled="disabled"
                </c:if>
                value="Create">
    </form>
</body>
</html>
