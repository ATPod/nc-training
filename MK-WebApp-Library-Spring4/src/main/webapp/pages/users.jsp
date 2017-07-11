<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

</head>
<body>

<jsp:include page="navbar.jsp"></jsp:include>
<%@ page errorPage="error.jsp" %>
<table class="table ">
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <c:if test="${user.role==\"ADMIN\"}">
            <th>Control</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:if test="${user!=null}">
        <c:forEach var="user" items="${users}" varStatus="index">
            <%-- <c:url var="deleteUrl" value="/controller?command=loan?delete=true?id=${loan.id}"/>--%>
            <tr>
                <td>${index.index+1}</td>
                <td><c:out value="${user.id}"></c:out></td>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:if test="${sessionScope.user.role==\"ADMIN\"||(user.role==\"USER\"&&sessionScope.user.id==user.id)}">
                        <c:out value="${user.password}"></c:out>
                </c:if></td>
                <c:if test="${sessionScope.user.role==\"ADMIN\"&&user.role!=\"ADMIN\"}">
                    <td>
                        <form method="POST" action="/users/delete">
                            <input type="hidden" name="user-delete-id" value="${ user.id }"/>
                            <input type="submit" value="delete" class="btn btn-danger btn-xs"/>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<sec:authorize access="hasRole('ADMIN')">
<form action="/users/update" method="get">
    <button type="submit" class="btn btn-primary">Update user</button>
</form>
</sec:authorize>
</body>
</html>
