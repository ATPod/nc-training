<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <title><spring:message code="msg.homePageTitle"/></title>
    </head>
    <body>
        <sec:authorize access="!isAuthenticated()">
            <jsp:forward page="/login"/>
        </sec:authorize>
        <sec:authorize access="hasRole('CLIENT')">
            <jsp:forward page="/client/catalog"/>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <jsp:forward page="/admin/clients"/>
        </sec:authorize>
    </body>
</html>
