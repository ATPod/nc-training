<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 23.05.2017
  Time: 23:45
  To change this transactionTemplate use File | Settings | File Templates.
--%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time Sheets</title>
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
                <c:url value="/manager/timeSheets" var="showTimeSheets" />

                <form method="get" action="${showTimeSheets}">
                    <input type="hidden" name="command" value="showTimeSheets">

                    <div class="form-group">
                        <label for="projectSelect">Project:</label>
                        <select class="form-control" name="projectId" id="projectSelect">
                            <c:forEach var="project" items="${requestScope.projectsByManager}">
                                <option value="${project.id}">#${project.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Show</button>
                </form>

                <app:timeSheetHolder>
                    <c:forEach var="timeSheet" items="${requestScope.timeSheets}">
                        <app:timeSheetItem timeSheet="${timeSheet}" />
                    </c:forEach>
                </app:timeSheetHolder>
            </div>
        </div>
    </div>
</body>
</html>
