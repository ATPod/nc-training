<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Products</title>
    <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
    <body>

    <jsp:include page="navbar.jsp"/>

<br>
    <br>
    <br><br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br><br><br><br><br><br><br><br><br><br><br><br>


    <h3>Add new product</h3>
    <form method="POST" action="/admin_add_product" role="form">
        <input type="text" name="productTitle" value="" placeholder="Title..." class="form-control"/><br/>
        <input type="number" name="productPrice" value="" placeholder="Price..." class="form-control"/><br/>
        <input type="submit" value="Add product" class="btn btn-primary"/>
    </form>

    <h3>Update existing product</h3>
    <form method="POST" action="/admin_update_product" role="form">
        <input type="number" name="productId" value="" placeholder="ID..." pattern="^[ 0-9]+$" class="form-control"/><br/>
        <input type="text" name="productTitle" value="" placeholder="New title..." class="form-control"/><br/>
        <input type="number" name="productPrice" value="" placeholder="New price..." pattern="^[ 0-9]+$" class="form-control"/><br/>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>

    <h3>List of all products</h3>

    <table class="table table-hover table-condensed table-striped">
        <caption>You can remove some of them from database.</caption>
        <thead>
        <tr>
            <th class="text-center"><strong>ID</strong></th>
            <th class="text-center"><strong>Title</strong></th>
            <th class="text-center"><strong>Price</strong></th>
            <th></th>
        </tr>
        </thead>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td class="text-center"><c:out value="${product.id}" /></td>
            <td class="text-center"><c:out value="${product.title}" /></td>
            <td class="text-center"><c:out value="${product.price}" /></td>
            <td class="text-center">
                <form name="removeForm" method="POST" action="/admin_remove_product">
                    <input type="hidden" name="productId" value="${ product.id }"/>
                    <input type="submit" value="Remove" class="btn btn-danger"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
${errorMessage}
</body>
</html>