<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" %>

<c:url var="home" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="home" />
</c:url>
<c:url var="logout" value="controller">
    <c:param name="command" value="logout" />
</c:url>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${home}">Home</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${logout}">Log out</a></li>
        </ul>
    </div>
</nav>