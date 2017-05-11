<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<c:url var="goCreateTor" value="controller">
    <c:param name="command" value="goCreateTerms" />
</c:url>
<c:url var="goShowTerms" value="controller">
    <c:param name="command" value="goShowTerms" />
</c:url>

<div class="panel panel-default">
    <ul class="nav">
        <li><a href="${goShowTerms}">Show my terms of reference</a></li>
        <li><a href="${goCreateTor}">Create terms of reference</a></li>
    </ul>
</div>