<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<%-- Customer's links --%>
<c:url var="goCreateTor" value="/customer/createTerms" />
<c:url var="goShowTerms" value="/customer/terms" />
<%-- Developer's links--%>
<c:url var="goTrack" value="/developer/timeSheets" />
<%-- Manager's links --%>
<c:url var="showPendingTerms" value="/manager/pendingTerms" />
<c:url var="assignDevelopers" value="/manager/assignDevelopers" />
<c:url var="showMyProjects" value="/manager/projects" />
<c:url var="issueInvoice" value="/manager/issueInvoice" />
<c:url var="showTimeSheets" value="/manager/timeSheets" />

<div class="panel panel-default">
    <ul class="nav">
        <c:choose>
            <c:when test="${user.userRole eq 'CUSTOMER'}">
                <li><a href="${goShowTerms}">Show my terms of reference</a></li>
                <li><a href="${goCreateTor}">Create terms of reference</a></li>
            </c:when>
            <c:when test="${user.userRole eq 'DEVELOPER'}">
                <li><a href="${goTrack}">Track My Activity</a></li>
            </c:when>
            <c:when test="${user.userRole eq 'MANAGER'}">
                <li><a href="${showPendingTerms}">Show pending terms of reference</a></li>
                <li><a href="${assignDevelopers}">Assign developers</a></li>
                <li><a href="${showMyProjects}">Show My Projects</a></li>
                <%--<li><a href="${issueInvoice}">Issue Invoice</a></li>--%>
                <li><a href="${showTimeSheets}">Show Time Sheets</a> </li>
            </c:when>
        </c:choose>
    </ul>
</div>