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

    <form name="taskControlForm" method="post" action="controller">
        <input type="hidden" name="command" value="removeTask">

        <input type="submit" class="btn btn-danger" value="Delete selected">
        <table class="table">
            <tr><td></td><td>Specification</td><td>Developers</td></tr>
            <c:forEach var="task" varStatus="i" items="${torBuilder.tasks}">
                <tr>
                    <td>
                        <label for="deleteTaskCheckbox"></label>
                        <input
                            id="deleteTaskCheckbox"
                            class="check-box"
                            type="checkbox"
                            name="task"
                            value="${i.index}">
                    </td>
                    <td rowspan="${task.taskQuotas.size() + 1}">
                        ${task.specification}
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <c:forEach var="taskQuota" items="${task.taskQuotas}">
                        <td></td>
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
        <%--<div class="row">--%>
            <div class="form-group">
                <label>
                    Specification:<br />
                    <textarea class="form-control" name="specification" required></textarea>
                </label><br />
            </div>
            <div class="form-group">
                <label>
                    Qualification:<br />
                    <select class="form-control" name="qualificationId" required>
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
            </div>
            <div class="form-group">
                <label>
                    Developers number:<br />
                    <input type="number" name="developersNumber" required>
                </label><br />
            </div>
        <%--</div>--%>

        <button class="btn btn-primary" type="submit">Submit</button>
        <button class="btn btn-default" type="reset">Reset</button>
    </form>

    <form name="createTor" method="post" action="controller">
        <jsp:useBean id="btnClass" class="java.lang.String" />
        <c:choose>
            <c:when test="${not empty torBuilder.tasks}">
                <c:set var="btnClass" value="btn-primary" />
            </c:when>
            <c:otherwise>
                <c:set var="btnClass" value="btn-disabled" />
            </c:otherwise>
        </c:choose>

        <input type="hidden" name="command" value="createTor">
        <button
                type="submit"
                class="btn ${btnClass}">Create</button>
    </form>
</body>
</html>
