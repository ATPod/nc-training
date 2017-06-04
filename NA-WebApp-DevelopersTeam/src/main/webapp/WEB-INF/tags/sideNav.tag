<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<%-- Customer's links --%>
<c:url var="goCreateTor" value="controller">
    <c:param name="command" value="goCreateTerms" />
</c:url>
<c:url var="goShowTerms" value="controller">
    <c:param name="command" value="goShowTerms" />
</c:url>
<%-- Developer's links--%>
<c:url var="track" value="controller">
    <c:param name="command" value="goTrack" />
</c:url>
<%-- Manager's links --%>
<c:url var="showPendingTerms" value="controller">
    <c:param name="command" value="goShowPendingTerms" />
</c:url>
<c:url var="assignDevelopers" value="controller">
    <c:param name="command" value="goShowAssignDevelopers" />
</c:url>
<c:url var="showMyProjects" value="controller">
    <c:param name="command" value="goShowProjects" />
</c:url>
<c:url var="issueInvoice" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="path.page.manager.issueInvoice" />
</c:url>
<c:url var="showTimeSheets" value="controller">
    <c:param name="command" value="showTimeSheets" />
</c:url>


<div class="panel panel-default">
    <ul class="nav">
        <c:choose>
            <c:when test="${sessionScope.user.userRole eq 'CUSTOMER'}">
                <li><a href="${goShowTerms}">Show my terms of reference</a></li>
                <li><a href="${goCreateTor}">Create terms of reference</a></li>
            </c:when>
            <c:when test="${sessionScope.user.userRole eq 'DEVELOPER'}">
                <li><a href="${track}">Track My Activity</a></li>
            </c:when>
            <c:when test="${sessionScope.user.userRole eq 'MANAGER'}">
                <li><a href="${showPendingTerms}">Show pending terms of reference</a></li>
                <li><a href="${assignDevelopers}">Assign developers</a></li>
                <li><a href="${showMyProjects}">Show My Projects</a></li>
                <li><a href="${issueInvoice}">Issue Invoice</a></li>
                <li><a href="${showTimeSheets}">Show Time Sheets</a> </li>
            </c:when>
        </c:choose>
    </ul>
</div>