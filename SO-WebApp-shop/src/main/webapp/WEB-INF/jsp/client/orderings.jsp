<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>SO-shop</title>
</head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <div class="mainBlock col-md-6 col-md-offset-3">
        <h1><spring:message code="msg.clientOrderingH1"/></h1>

        <table class="table table-hover table-condensed table-striped">
            <caption><spring:message code="msg.clientOrderingTableCaption"/></caption>
            <thead>
            <tr>
                <th class="text-center col-md-1"><strong>ID</strong></th>
                <th class="text-center col-md-2"><strong><spring:message code="msg.clientOrderingTablePaid"/></strong></th>
                <th class="col-md-2"></th>
                <th class="col-md-1"></th>
            </tr>
            </thead>
            <c:forEach var="ordering" items="${orderingList}">
                <tr>
                    <td class="text-center"><c:out value="${ordering.id}" /></td>
                    <td class="text-center">
                        <c:choose>
                            <c:when test="${ordering.paid == '1'}"><spring:message code="msg.clientOrderingPaidYes"/></c:when>
                            <c:when test="${ordering.paid == '0'}"><spring:message code="msg.clientOrderingPaidNo"/></c:when>
                        </c:choose>
                    </td>
                    <td>
                        <form method="GET" action="/client/products_ordering">
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="<spring:message code="msg.clientOrderingProductsInput"/>" class="btn btn-info"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="/client/pay_for_ordering">
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="<spring:message code="msg.clientOrderingPaidInput"/>" class="btn btn-warning"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        ${errorMessage}
    </body>
</html>

