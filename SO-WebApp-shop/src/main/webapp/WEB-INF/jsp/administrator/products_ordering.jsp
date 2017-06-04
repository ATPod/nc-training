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
            <h3><spring:message code="msg.adminProductOrderingH3List"/>${orderingId}</h3>
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th class="text-center"><strong>ID</strong></th>
                        <th class="text-center"><strong><spring:message code="msg.adminProductOrderingTitle"/></strong></th>
                        <th class="text-center"><strong><spring:message code="msg.adminProductOrderingPrice"/></strong></th>
                    </tr>
                </thead>
                <c:forEach var="product" items="${productListOrdering}">
                    <tr>
                        <td class="text-center"><c:out value="${product.id}" /></td>
                        <td class="text-center"><c:out value="${product.title}" /></td>
                        <td class="text-center"><c:out value="${product.price}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
