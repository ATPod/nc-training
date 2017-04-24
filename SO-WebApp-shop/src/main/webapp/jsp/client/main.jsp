<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>SO-shop</title>
    </head>
    <body>

        ${firstname} ${lastname} <br/>
        <a href="controller?command=client_go_to_orderings">My orderings</a> <br/>
        <a href="controller?command=client_go_to_bag">Bag</a> <br/>
        <a href="controller?command=client_go_to_settings">Settings</a> <br/>
        <a href="controller?command=logout">Log out</a> <br/><br/>

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
                        <form name="loginForm" method="POST" action="controller">
                            <input type="hidden" name="command" value="client_add_to_bag"/>
                            <input type="hidden" name="productId" value="${ product.id }"/>
                            <input type="submit" value="Add to bag"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        ${errorMessage}
    </body>
</html>
