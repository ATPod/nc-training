<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Products</title>
</head>
<body>

${name} <br/><br/>
    <a href="controller?command=admin_go_to_clients">Clients</a> <br/>
    <a href="controller?command=admin_go_to_orderings">Orderings</a> <br/>
    <a href="controller?command=admin_go_to_settings">Settings</a> <br/>
    <a href="controller?command=logout">Log out</a> <br/><br/>

<form name="addProductForm" method="POST" action="controller">
    <input type="hidden" name="command" value="admin_add_product"/>
    Title:<br/>
    <input type="text" name="productTitle" value=""/><br/>
    Price:<br/>
    <input type="text" name="productPrice" pattern="^[ 0-9]+$" value=""/><br/>
    <input type="submit" value="Add product"/>
</form>
<form name="updateProductTitleForm" method="POST" action="controller">
    <input type="hidden" name="command" value="admin_update_product_title"/>
    ID:<br/>
    <input type="text" name="productId" pattern="^[ 0-9]+$" value=""/><br/>
    Title:<br/>
    <input type="text" name="productTitle" value=""/><br/>
    <input type="submit" value="Update title"/>
</form>
<form name="updateProductPriceForm" method="POST" action="controller">
    <input type="hidden" name="command" value="admin_update_product_price"/>
    ID:<br/>
    <input type="text" name="productId" pattern="^[ 0-9]+$" value=""/><br/>
    Price:<br/>
    <input type="text" name="productPrice" pattern="^[ 0-9]+$" value=""/><br/>
    <input type="submit" value="Update price"/>
</form>

<table border="1">
    <tr bgcolor="#CCCCCC">
        <td align="center"><strong>ID</strong></td>
        <td align="center"><strong>Title</strong></td>
        <td align="center"><strong>Price</strong></td>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td><c:out value="${product.id}" /></td>
            <td><c:out value="${product.title}" /></td>
            <td><c:out value="${product.price}" /></td>
            <td>
                <form name="removeForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="admin_remove_product"/>
                    <input type="hidden" name="productId" value="${ product.id }"/>
                    <input type="submit" value="Remove"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
${errorMessage}
</body>
</html>