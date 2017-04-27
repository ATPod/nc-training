<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>My orderings</title>
</head>
    <body>

        ${firstname} ${lastname}<br>
        <a href="controller?command=client_go_to_bag">Bag</a> <br/>
        <a href="controller?command=client_go_to_settings">Settings</a> <br/>
        <a href="controller?command=client_go_to_main">Back</a> <br/>
        <a href="controller?command=logout">Log out</a> <br/><br/>

        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>ID</strong></td>
                <td align="center"><strong>Payment</strong></td>
            </tr>
            <c:forEach var="ordering" items="${orderingList}">
                <tr>
                    <td><c:out value="${ordering.id}" /></td>
                    <td><c:out value="${ordering.paid}" /></td>
                    <td>
                        <form method="POST" action="controller">
                            <input type="hidden" name="command" value="client_go_to_products"/>
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="Products"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="controller">
                            <input type="hidden" name="command" value="client_pay_for_ordering"/>
                            <input type="hidden" name="orderingId" value="${ ordering.id }"/>
                            <input type="submit" value="Pay"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        ${errorMessage}
    </body>
</html>

