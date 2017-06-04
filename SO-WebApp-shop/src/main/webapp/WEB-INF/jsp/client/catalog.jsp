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
        <h1><spring:message code="msg.clientCatalogH1"/></h1>

        <c:if test="${user.blacklist == 1}">
            <div class="alert alert-warning">
                <spring:message code="msg.alertBlackList"/>
            </div>
            <br/>
        </c:if>

        <table class="table table-hover table-striped">
            <caption><spring:message code="msg.clientCatalogTableCaption"/></caption>
            <thead>
            <tr>
                <th><strong>ID</strong></th>
                <th><strong><spring:message code="msg.clientCatalogTableTitle"/></strong></th>
                <th><strong><spring:message code="msg.clientCatalogTablePrice"/></strong></th>
                <th></th>
            </tr>
            </thead>

            <c:forEach var="product" items="${productList}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.title}" /></td>
                    <td><c:out value="${product.price}" /> BYN</td>
                    <td>
                        <form method="POST" action="/client/add_to_bag">
                            <input type="hidden" name="productId" value="${ product.id }"/>
                            <input type="submit" value="<spring:message code="msg.clientCatalogAddToBagInput"/>" class="btn btn-success"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    ${errorMessage}
    </body>
</html>
