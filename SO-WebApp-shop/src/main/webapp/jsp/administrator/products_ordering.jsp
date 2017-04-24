<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Products by ordering</title>
</head>
<body>

${name} <br/><br/>
<a href="controller?command=admin_go_to_clients">Clients</a> <br/>
<a href="controller?command=admin_go_to_products">Products</a> <br/>
<a href="controller?command=admin_go_to_settings">Settings</a> <br/>
<a href="controller?command=admin_go_to_orderings">Back</a> <br/>
<a href="controller?command=logout">Log out</a> <br/><br/>

<table border="1">
    <tr bgcolor="#CCCCCC">
        <td align="center"><strong>ID</strong></td>
        <td align="center"><strong>Title</strong></td>
        <td align="center"><strong>Price</strong></td>
    </tr>
    <c:forEach var="product" items="${productListOrdering}">
        <tr>
            <td><c:out value="${product.id}" /></td>
            <td><c:out value="${product.title}" /></td>
            <td><c:out value="${product.price}" /></td>
        </tr>
    </c:forEach>
</table>
${errorMessage}
</body>
</html>
