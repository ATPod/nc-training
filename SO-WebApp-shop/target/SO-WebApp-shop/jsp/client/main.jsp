<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>SO-shop</title>
    </head>
    <body>

        Welcome, ${firstname} ${lastname}
        <a href="controller?command=GoToSettings">Settings</a> <br/>
        <a href="controller?command=GoToMyOrderings">My orderings</a> <br/>
        <a href="controller?command=GoToBag">Bag</a> <br/>
        <a href="controller?command=LogOut">Log out</a> <br/>

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
                            <input type="hidden" name="command" value="addToBag"/>
                            <input type="hidden" name="idProduct" value="${ product.id }"/>
                            <input type="submit" value="Add to bag"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
