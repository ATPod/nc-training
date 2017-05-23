<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Bag</title>
        <link href=<c:url value="../../static/css/bootstrap.min.css"/> rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <h3>Make ordering</h3>

    <table class="table table-hover table-condensed table-striped">
        <caption>List of products in bag.</caption>
        <thead>
        <tr>
            <th class="text-center"><strong>ID</strong></th>
            <th class="text-center"><strong>Title</strong></th>
            <th class="text-center"><strong>Price</strong></th>
            <th></th>
        </tr>
        </thead>

        <c:forEach var="product" items="${bag}">
            <tr>
                <td class="text-center"><c:out value="${product.id}" /></td>
                <td class="text-center"><c:out value="${product.title}" /></td>
                <td class="text-center"><c:out value="${product.price}" /></td>
                <td class="text-center">
                        <form method="POST" action="/client_remove_from_bag">
                            <input type="hidden" name="productId" value="${ product.id }"/>
                            <input type="submit" value="Remove" class="btn btn-danger"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    <form method="POST" action="/client_make_ordering">
        <input type="submit" value="Make ordering!" class="btn btn-success"/>
    </form>

        ${errorMessage}
        </body>
</html>
