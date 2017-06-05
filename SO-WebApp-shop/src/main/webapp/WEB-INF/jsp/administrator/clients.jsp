<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>SO-shop</title>
    </head>

    <body>

    <jsp:include page="navbar.jsp"/>
    <div class="mainBlock col-md-8 col-md-offset-2">
    <h2><spring:message code="msg.clientListH3Title"/></h2>
        <table class="table table-hover table-striped">
            <caption><spring:message code="msg.clientCaption"/></caption>
            <thead>
            <tr>
                <th class="text-center"><strong>ID</strong></th>
                <th class="text-center"><strong><spring:message code="msg.email"/></strong></th>
                <th class="text-center"><strong><spring:message code="msg.clientFirstName"/></strong></th>
                <th class="text-center"><strong><spring:message code="msg.clientLastName"/></strong></th>
                <th class="text-center"><strong><spring:message code="msg.clientState"/></strong></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="client" items="${clientList}">
                <tr>
                    <td class="text-center"><c:out value="${client.id}" /></td>
                    <td class="text-center"><c:out value="${client.email}" /></td>
                    <td class="text-center"><c:out value="${client.firstname}" /></td>
                    <td class="text-center"><c:out value="${client.lastname}" /></td>
                    <td class="text-center">
                        <c:choose>
                            <c:when test="${client.blacklist == '1'}"><spring:message code="msg.clientBlock"/></c:when>
                            <c:when test="${client.blacklist == '0'}"><spring:message code="msg.clientNormal"/></c:when>
                        </c:choose>
                    </td>
                    <td class="text-center">
                        <form method="POST" action="/admin/change_black_list">
                            <input type="hidden" name="clientId" value="${ client.id }"/>
                            <input type="submit" value="<spring:message code="msg.clientChangeState"/>" class="btn btn-warning"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </body>
</html>
