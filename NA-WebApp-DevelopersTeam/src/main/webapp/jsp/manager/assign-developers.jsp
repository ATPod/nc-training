<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>
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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <app:topNav/>

    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <app:sideNav/>
            </div>

            <div class="col-lg-9">
                <form method="get" action="controller">
                    <input type="hidden" name="command" value="goShowAssignDevelopers">
                    <div class="form-group">
                        <app:qualificationSelect controlName="qualificationId"/>
                    </div>
                    <button class="btn btn-primary" type="submit">
                        Show
                    </button>
                </form>
                <form method="post" action="controller">
                    <input type="hidden" name="command" value="assignDevelopers">
                    <div class="form-group">
                        <label for="projectSelect">Project:</label>
                        <select class="form-control" name="projectId" id="projectSelect">
                            <c:forEach var="project" items="${requestScope.projectsByManager}">
                                <option value="${project.id}">#${project.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!-- TODO: show tasks here -->

                    <table class="table">
                        <tr><th>Select</th><th>Name</th><th>Qualification</th></tr>
                        <c:forEach
                                var="developer"
                                varStatus="status"
                                items="${requestScope.unassignedDevelopers}">
                            <tr>
                                <td><input
                                        id="developerIdCheckbox${status.index}"
                                        type="checkbox"
                                        name="developerId"
                                        value="${developer.id}">
                                </td>
                                <td>
                                    <label for="developerIdCheckbox${status.index}">
                                        ${developer.name}
                                    </label>
                                </td>
                                <td>${developer.qualification.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" type="submit">Assign</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
