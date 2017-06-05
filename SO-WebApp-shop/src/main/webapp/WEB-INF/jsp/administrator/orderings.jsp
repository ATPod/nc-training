<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>So-shop</title>
    <link href=<c:url value="../../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <div class="mainBlock col-md-6 col-md-offset-3">
    <h2><spring:message code="msg.adminOrderingsListH3"/></h2>
        <table class="table table-hover table-condensed table-striped">
            <caption><spring:message code="msg.adminOrderingsTableCaption"/></caption>
            <thead>
                <tr>
                    <th class="text-center"><strong><spring:message code="msg.adminOrderingsIdOrdering"/></strong></th>
                    <th class="text-center"><strong><spring:message code="msg.adminOrderingsIdClient"/></strong></th>
                    <th class="text-center"><strong><spring:message code="msg.adminOrderingsEmailClient"/></strong></th>
                    <th class="text-center"><strong><spring:message code="msg.adminOrderingsPaid"/></strong></th>
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
                            <c:when test="${ordering.paid == '1'}"><spring:message code="msg.adminOrderingsYes"/></c:when>
                            <c:when test="${ordering.paid == '0'}"><spring:message code="msg.adminOrderingsNo"/></c:when>
                        </c:choose>
                    </td>
                    <td class="text-center">
                        <form method="GET" action="/admin/products_ordering">
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="<spring:message code="msg.adminOrderingsProducts"/>" class="btn btn-info"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>
