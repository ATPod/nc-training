<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 26.04.2017
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign developers</title>
</head>
<body>
    <jsp:useBean
            id="managerService"
            scope="application"
            class="by.training.nc.dev5.service.ManagerService" />
    <jsp:useBean id="helpService"
            scope="application"
            class="by.training.nc.dev5.service.HelpService" />
    <jsp:useBean
            id="qualification"
            scope="request"
            class="by.training.nc.dev5.entity.Qualification" />

    <ul>
        <c:forEach var="q" items="${helpService.qualifications}">
            <c:url var="showDevelopersUrl" value="controller">
                <c:param name="command" value="showDevelopers" />
                <c:param name="qualificationId" value="${q.id}" />
            </c:url>
            <li><a href="${showDevelopersUrl}">${q.name}</a></li>
        </c:forEach>
    </ul>


    <%--<form>--%>
        <%--<label for="qualificationSelect">Qualification:</label>--%>
        <%--<select id="qualificationSelect" name="qualificationId">--%>
            <%----%>
        <%--</select>--%>
    <%--</form>--%>
    <form>
        <table>
            <tr><td></td><td>Name</td><td>Qualification</td></tr>
            <c:forEach
                    var="developer"
                    items="${requestScope.unassignedDevelopers}">
                <jsp:useBean
                        id="developer"
                        scope="page"
                        class="by.training.nc.dev5.entity.Developer" />
                <tr>
                    <td><input
                            id="developerIdCheckbox"
                            type="checkbox"
                            name="developerId"
                            value="${developer.id}">
                    </td>
                    <td>
                        <label for="developerIdCheckbox">
                            ${developer.name}
                        </label>
                    </td>
                    <td>${developer.qualification.name}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
