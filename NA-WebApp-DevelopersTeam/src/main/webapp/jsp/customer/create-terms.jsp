<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

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

    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <app:customerSideNav />
            </div>
            <div class="col-lg-9">
                <c:if test="${not empty sessionScope.createdTerms}">
                    <app:termsHolder>
                        <app:termsItem terms="${sessionScope.createdTerms}" />
                    </app:termsHolder>
                </c:if>
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
                                        items="${requestScope.qualifications}">

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
                            <input type="number" name="developersNumber" min="1" required>
                        </label><br />
                    </div>
                    <%--</div>--%>

                    <button class="btn btn-primary" type="submit">Add</button>
                    <button class="btn btn-default" type="reset">Reset</button>
                </form>

                <c:if test="${not empty sessionScope.createdTerms}">
                    <form name="createTerms" method="post" action="controller">
                        <input type="hidden" name="command" value="createTerms">
                        <button type="submit" class="btn btn-default">Create</button>
                    </form>
                    <form name="deleteTerms" method="post" action="controller">
                        <input type="hidden" name="command" value="cancelTerms">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Cancel</button>
                        </div>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
