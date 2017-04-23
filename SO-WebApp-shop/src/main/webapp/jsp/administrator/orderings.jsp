<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Orderings</title>
</head>
    <body>

        ${name} <br/><br/>
        <a href="controller?command=admin_go_to_clients">Clients</a> <br/>
        <a href="controller?command=admin_go_to_products">Products</a> <br/>
        <a href="controller?command=admin_go_to_settings">Settings</a> <br/>
        <a href="controller?command=logout">Log out</a> <br/><br/>

        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>ID</strong></td>
                <td align="center"><strong>ID client</strong></td>
                <td align="center"><strong>Payment</strong></td>
            </tr>
            <c:forEach var="ordering" items="${orderingList}">
                <tr>
                    <td><c:out value="${ordering.id}" /></td>
                    <td><c:out value="${ordering.client.id}" /></td>
                    <td><c:out value="${ordering.paid}" /></td>
                    <td>
                        <form method="POST" action="controller">
                            <input type="hidden" name="command" value="admin_go_to_products_ordering"/>
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="Products"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        ${errorMessage}
    </body>
</html>
