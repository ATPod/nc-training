<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Orderings</title>
    <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <h3>List of all orderings</h3>
        <table class="table table-hover table-condensed table-striped">
            <caption>You can load a list of products for each ordering.</caption>
            <thead>
                <tr>
                    <th class="text-center"><strong>ID ordering</strong></th>
                    <th class="text-center"><strong>ID client</strong></th>
                    <th class="text-center"><strong>E-mail client</strong></th>
                    <th class="text-center"><strong>Paid</strong></th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach var="ordering" items="${orderingList}">
                <tr>
                    <td class="text-center"><c:out value="${ordering.id}" /></td>
                    <td class="text-center"><c:out value="${ordering.client.id}" /></td>
                    <td class="text-center"><c:out value="${ordering.client.email}" /></td>
                    <td class="text-center">
                        <c:choose>
                            <c:when test="${ordering.paid == '1'}">Yes</c:when>
                            <c:when test="${ordering.paid == '0'}">No</c:when>
                        </c:choose>
                    </td>
                    <td class="text-center">
                        <form method="GET" action="/admin_go_to_products_ordering">
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="Products" class="btn btn-info"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        ${errorMessage}
    </body>
</html>
