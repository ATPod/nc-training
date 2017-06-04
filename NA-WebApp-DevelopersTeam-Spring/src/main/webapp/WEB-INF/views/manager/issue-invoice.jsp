<%@ taglib prefix="app"
           uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: F1
  Date: 13.05.2017
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Issue Invoice</title>
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
                <c:url value="/manager/issueInvoice" var="issueInvoice" />

                <form:form method="post" id="issueInvoiceForm" action="${issueInvoice}">
                    <div class="form-group">
                        <app:projectSelect
                                parameterName="projectId"
                                projectsList="${projectsByManager}"/>
                    </div>
                    <div class="form-group">
                        <input type="text" id="invoicePrice" class="form-control" name="price">
                    </div>
                    <button class="btn btn-primary" type="submit">Issue</button>
                </form:form>
            </div>
        </div>
    </div>

    <script>
        $('#issueInvoiceForm').submit(function () {
            var price = $('#invoicePrice').attribute('value');

            return /^[0-9]*\.?[0-9]*/.test(price);
        })
    </script>
</body>
</html>
