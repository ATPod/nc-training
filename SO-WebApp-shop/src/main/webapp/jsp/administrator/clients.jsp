<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Clients</title>
    </head>
    <body>

        ${name} <br/><br/>
        <a href="controller?command=admin_go_to_orderings">Orderings</a> <br/>
        <a href="controller?command=admin_go_to_products">Products</a> <br/>
        <a href="controller?command=admin_go_to_settings">Settings</a> <br/>
        <a href="controller?command=logout">Log out</a> <br/><br/>

        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>ID</strong></td>
                <td align="center"><strong>E-mail</strong></td>
                <td align="center"><strong>First name</strong></td>
                <td align="center"><strong>Last name</strong></td>
                <td align="center"><strong>Black list</strong></td>
            </tr>
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td><c:out value="${client.id}" /></td>
                    <td><c:out value="${client.email}" /></td>
                    <td><c:out value="${client.firstname}" /></td>
                    <td><c:out value="${client.lastname}" /></td>
                    <td><c:out value="${client.blacklist}" /></td>
                    <td>
                        <form method="POST" action="controller">
                            <input type="hidden" name="command" value="admin_change_black_list"/>
                            <input type="hidden" name="clientId" value="${ client.id }"/>
                            <input type="submit" value="Change state"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        ${errorMessage}
    </body>
</html>
