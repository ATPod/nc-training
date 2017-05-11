<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<c:url var="track" value="controller">
    <c:param name="command" value="goTrack" />
</c:url>

<div class="panel panel-default">
    <ul class="nav">
        <li><a href="${track}">Track My Activity</a></li>
    </ul>
</div>