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

    <h3><spring:message code="msg.adminProductsH3AddProduct"/></h3>
        <div class="profileBlock">
    <form method="POST" action="/admin/add_product" role="form">
        <input type="text" name="productTitle" value="" placeholder="<spring:message code="msg.adminProductsProductTitlePlaceholder"/>" class="form-control"/><br/>
        <input type="number" name="productPrice" value="" placeholder="<spring:message code="msg.adminProductsProductPrcePlaceholder"/>" class="form-control"/><br/>
        <input type="submit" value="<spring:message code="msg.adminProductsAddProductInput"/>" class="btn btn-primary"/>
    </form>
        </div>
    <br/>
    <h3><spring:message code="msg.adminProductsH3UpdateProduct"/></h3>
        <div class="profileBlock">
    <form method="POST" action="/admin/update_product" role="form">
        Product ID: <select class="form-control" name="productId">
            <c:forEach items="${productList}" var="product">
                <option value="${product.id}">${product.id}</option>
            </c:forEach>
        </select><br/>
        <input type="text" name="productTitle" value="" placeholder="<spring:message code="msg.adminProductsUpdateProductTitlePlaceholder"/>" class="form-control"/><br/>
        <input type="number" name="productPrice" value="" placeholder="<spring:message code="msg.adminProductsUpdateProductProcePlaceholder"/>" pattern="^[ 0-9]+$" class="form-control"/><br/>
        <input type="submit" value="<spring:message code="msg.adminProductsUpdateButton"/>" class="btn btn-primary"/>
    </form>
        </div>
        <br/>
    <h3><spring:message code="msg.adminProductsH3ListOfProducts"/></h3>

    <table class="table table-hover table-condensed table-striped">
        <caption><spring:message code="msg.adminProductsListCaption"/></caption>
        <thead>
        <tr>
            <th class="text-center"><strong>ID</strong></th>
            <th class="text-center"><strong><spring:message code="msg.adminProductsListTitle"/></strong></th>
            <th class="text-center"><strong><spring:message code="msg.adminProductsListPrice"/></strong></th>
            <th></th>
        </tr>
        </thead>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td class="text-center"><c:out value="${product.id}" /></td>
            <td class="text-center"><c:out value="${product.title}" /></td>
            <td class="text-center"><c:out value="${product.price}" /></td>
            <td class="text-center">
                <form name="removeForm" method="POST" action="/admin/remove_product">
                    <input type="hidden" name="productId" value="${ product.id }"/>
                    <input type="submit" value="<spring:message code="msg.adminProductsListRemove"/>" class="btn btn-danger"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
    </div>
</body>
</html>