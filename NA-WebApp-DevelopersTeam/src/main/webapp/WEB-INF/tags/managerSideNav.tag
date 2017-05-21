<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<c:url var="showPendingTerms" value="controller">
    <c:param name="command" value="goShowPendingTerms" />
</c:url>
<c:url var="assignDevelopers" value="controller">
    <c:param name="command" value="goShowAssignDevelopers" />
</c:url>
<c:url var="showMyProjects" value="controller">
    <c:param name="command" value="goShowProjects" />
</c:url>

<div class="panel panel-default">
    <ul class="nav">
        <li><a href="${showPendingTerms}">Show pending terms of reference</a></li>
        <li><a href="${assignDevelopers}">Assign developers</a></li>
        <li><a href="${showMyProjects}">Show My Projects</a></li>
    </ul>
</div>