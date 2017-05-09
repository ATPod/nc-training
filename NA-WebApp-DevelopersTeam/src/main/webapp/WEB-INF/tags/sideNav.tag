<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<c:url var="createTor" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="path.page.customer.createTor" />
</c:url>
<c:url var="showMyTors" value="controller">
    <c:param name="command" value="showTerms" />
</c:url>

<c:url var="showPendingTors" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="manager.showPendingTors" />
</c:url>
<c:url var="assignDevelopers" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="manager.assignDevelopers" />
</c:url>


<div class="panel panel-default">
    <ul class="nav">
        <c:choose>
            <c:when test="${sessionScope.user.userRole eq 'CUSTOMER'}">
                <li><a href="${showMyTors}">Show my terms of reference</a></li>
                <li><a href="${createTor}">Create terms of reference</a></li>
            </c:when>
            <c:when test="${sessionScope.user.userRole eq 'MANAGER'}">
                <li><a href="${showPendingTors}">Show pending terms of reference</a></li>
                <li><a href="${assignDevelopers}">Assign developers</a></li>
            </c:when>
        </c:choose>
    </ul>
</div>