<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page isELIgnored="false" %>
<html>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/index.jsp">Home</a>
    <div class="collapse navbar-collapse" id="navbar-id">
        <ul class="navbar-nav">
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item active">
                    <a class="nav-link" href="/users">Users </a>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ADMIN','USER')">
            <li class="nav-item active">
                <a class="nav-link" href="/books">Books </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/loans">Loans </a>
            </li>
            </sec:authorize>
        </ul>
        <ul class="nav navbar-nav navbar-right  my-2 my-lg-0" >
            <c:if test="${user==null}">
                <li class="nav-item active">
                    <a class="nav-link" href="/login">Login </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/signup">Register</a>
                </li>
            </c:if>
            <c:if test="${user!=null}">
                <li class="nav-item active">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
</html>
