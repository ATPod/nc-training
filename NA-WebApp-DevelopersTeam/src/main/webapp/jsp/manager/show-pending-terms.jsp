<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pending Terms of Reference</title>
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
            <app:managerSideNav/>
        </div>
        <div class="col-lg-9">
            <h2>Pending Terms of Reference</h2>

            <app:termsHolder>
                <c:forEach var="terms" items="${requestScope.pendingTerms}">
                    <app:termsItem terms="${terms}" />
                </c:forEach>
            </app:termsHolder>
        </div>
    </div>
</div>

</body>
</html>
