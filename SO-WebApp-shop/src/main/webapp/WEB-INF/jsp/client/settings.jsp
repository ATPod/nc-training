<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <title>SO-shop</title>
    </head>
    <body>

    <jsp:include page="navbar.jsp"/>

    <div class="mainBlock col-md-6 col-md-offset-3">
        <h1><spring:message code="msg.clientSettingsH1"/></h1>
        <br/>
        <div class="col-md-8 col-md-offset-2">
            <form method="POST" action="/client/update" role="form">
                <input type="hidden" name="command" value="client_update"/>
                <input type="text" name="c_firstname" pattern="^[a-zA-Z]+$" value="${user.firstname}" class="form-control" placeholder="<spring:message code="msg.clientSettingsFirstNamePlaceholder"/>"/><br/>
                <input type="text" name="c_lastname" pattern="^[a-zA-Z]+$" value="${user.lastname}" class="form-control" placeholder="<spring:message code="msg.clientSettingsLastNamePlaceholder"/>"/><br/>
                <input type="text" name="c_email" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$" value="${user.email}" class="form-control" placeholder="<spring:message code="msg.clientSettingsEmailPlaceholder"/>"/><br/>
                <input type="password" name="password" value="${user.password}" placeholder="<spring:message code="msg.clientSettingsPasswordPlaceholder"/>" class="form-control"/><br/>
                <input type="submit" value="<spring:message code="msg.clientSettingsUpdateInput"/>" class="btn btn-success"/>
            </form>
        </div>
    </div>
    </body>
</html>

