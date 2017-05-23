<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Products by ordering</title>
    <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="navbar.jsp"/>

<br>
<br>
<br><br><br><br>


<h3>List of products for ordering with ID ${orderingId}</h3>

<table class="table table-hover table-condensed table-striped">
    <thead>
    <tr>
        <th class="text-center"><strong>ID</strong></th>
        <th class="text-center"><strong>Title</strong></th>
        <th class="text-center"><strong>Price</strong></th>
        <th></th>
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
${errorMessage}
</body>
</html>
