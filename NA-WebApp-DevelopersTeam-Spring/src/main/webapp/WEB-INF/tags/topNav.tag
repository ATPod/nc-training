<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty" %>

<c:url var="home" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="home" />
</c:url>
<c:url var="logout" value="controller">
    <c:param name="command" value="logout" />
</c:url>
<c:url var="login" value="controller">
    <c:param name="command" value="go" />
    <c:param name="location" value="login" />
</c:url>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${home}">Home</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li><a>Logged in as ${sessionScope.user.name}</a></li>
                    <li><a href="${logout}">Log out</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${login}">Log in</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>