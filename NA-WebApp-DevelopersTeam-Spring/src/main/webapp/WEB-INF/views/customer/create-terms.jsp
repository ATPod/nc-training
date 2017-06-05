<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app"
           uri="http://nikitatroshenko.ddns.net/NA-DevelopersTeam/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create Terms of Reference</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <app:topNav/>
    <fmt:requestEncoding value="866" />

    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <app:sideNav />
            </div>
            <div class="col-lg-9">
                <c:if test="${not empty sessionScope.createdTerms}">
                    <app:termsHolder>
                        <app:termsItem terms="${sessionScope.createdTerms}" />
                    </app:termsHolder>
                </c:if>
                <hr>

                <c:url value="/customer/addTask" var="addTaskUrl" />
                <form:form method="post" name="addTask" action="${addTaskUrl}">
                    <div class="form-group">
                        <label>
                            Specification:<br />
                            <textarea class="form-control" name="specification" required></textarea>
                        </label><br />
                    </div>
                    <div class="form-group">
                        <label>
                            Qualification:<br />
                            <app:qualificationSelect
                                    controlName="qualificationId"
                                    qualifications="${qualifications}"/>
                        </label>
                        <br />
                    </div>
                    <div class="form-group">
                        <label>
                            Developers number:<br />
                            <input type="number" name="developersNumber" min="1" required>
                        </label><br />
                    </div>

                    <button class="btn btn-primary" type="submit">Add</button>
                    <button class="btn btn-default" type="reset">Reset</button>
                </form:form>

                <c:url value="/customer/createTerms" var="createTermsUrl" />
                <c:url value="/customer/cancelTerms" var="cancelTermsUrl" />
                <c:if test="${not empty sessionScope.createdTerms.tasks}">
                    <form:form name="createTerms" method="post" action="${createTermsUrl}">
                        <button type="submit" class="btn btn-default">Create</button>
                    </form:form>
                    <form:form name="deleteTerms" method="post" action="${cancelTermsUrl}">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Cancel</button>
                        </div>
                    </form:form>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
