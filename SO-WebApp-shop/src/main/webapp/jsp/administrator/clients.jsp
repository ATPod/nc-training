<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Clients</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>

    <body>

    <jsp:include page="navbar.jsp"/>


    <h3>List of all clients</h3>
    <div class="row">
        <table class="table table-hover table-condensed table-striped col-md-offset-2 col-md-6" style="width: auto;">
            <caption>You can change state of each client.</caption>
            <thead>
            <tr>
                <th class="text-center col-md-1"><strong>ID</strong></th>
                <th class="text-center col-md-2"><strong>E-mail</strong></th>
                <th class="text-center col-md-2"><strong>First name</strong></th>
                <th class="text-center col-md-1"><strong>Last name</strong></th>
                <th class="text-center col-md-1"><strong>State</strong></th>
                <th class="col-md-1"></th>
            </tr>
            </thead>
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td class="text-center"><c:out value="${client.id}" /></td>
                    <td class="text-center"><c:out value="${client.email}" /></td>
                    <td class="text-center"><c:out value="${client.firstname}" /></td>
                    <td class="text-center"><c:out value="${client.lastname}" /></td>
                    <td class="text-center">
                        <c:choose>
                            <c:when test="${client.blacklist == '1'}">Blocked</c:when>
                            <c:when test="${client.blacklist == '0'}">Normal</c:when>
                        </c:choose>
                    </td>
                    <td class="text-center">
                        <form method="POST" action="/admin_change_black_list">
                            <input type="hidden" name="clientId" value="${ client.id }"/>
                            <input type="submit" value="Change state" class="btn btn-warning"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

        ${errorMessage}
    </body>
</html>
