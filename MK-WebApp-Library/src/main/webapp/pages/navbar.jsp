<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/index.jsp">Home</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test="${user.role==\"ADMIN\"}">
            <li class="nav-item active">
                <a class="nav-link" href="/controller?command=users">Users </a>
            </li>
            </c:if>
            <li class="nav-item active">
                <a class="nav-link" href="/controller?command=books">Books </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/controller?command=loans">Loans </a>
            </li>

        </ul>
        <ul class="nav navbar-nav navbar-right  my-2 my-lg-0" >
            <c:if test="${isLogged!=true}">
                <li class="nav-item active">
                    <a class="nav-link" href="/controller?command=toLogin">Login </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/controller?command=toSignup">Register</a>
                </li>
            </c:if>
            <c:if test="${isLogged==true}">
                <li class="nav-item active">
                    <a class="nav-link" href="/controller?command=logout">Logout</a>
                </li>
            </c:if>


        </ul>
    </div>
</nav>
</html>
