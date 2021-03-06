<%@ taglib prefix="app"
           uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Developer panel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<app:topNav />

<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <app:sideNav />
        </div>
        <div class="col-lg-9">
            <h3>Hi, ${sessionScope.user.name}</h3>
        </div>
    </div>
</div>
</body>
</html>
