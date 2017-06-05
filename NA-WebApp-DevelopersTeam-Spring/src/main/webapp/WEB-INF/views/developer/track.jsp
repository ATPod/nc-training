<%@ taglib
        prefix="app"
        uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 11.05.2017
  Time: 13:45
  To change this transactionTemplate use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Track My Activity</title>
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
            <app:sideNav />
        </div>
        <div class="col-lg-9">
            <c:url var="trackTime" value="/developer/trackTime" />

            <form:form class="form-inline"
                  method="post"
                  name="trackTimeForm"
                  action="${trackTime}">

                <div class="form-group">
                    <label>
                        Time spent in minutes:
                        <input class="form-control" type="number" name="time">
                    </label>
                    <button class="btn btn-primary" type="submit">Track</button>
                </div>
            </form:form>
            <p class="text-danger">
                ${requestScope.trackTimeErrorMessage}
            </p>
            <hr />
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
