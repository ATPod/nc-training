<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<table class="table">
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>Book</th>
        <th>Loan type</th>

        <c:if test="${user.role==\"ADMIN\"}">
            <th>Control</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:if test="${isLogged==true}">
        <c:forEach var="loan" items="${loans}" varStatus="index">
           <%-- <c:url var="deleteUrl" value="/controller?command=loan?delete=true?id=${loan.id}"/>--%>
            <tr>
                <td>${index.index+1}</td>
                <td><c:out value="${loan.id}"></c:out></td>
                <td><c:out value="${loan.user}"></c:out></td>
                <td><c:out value="${loan.book}"></c:out></td>
                <td><c:out value="${loan.loanType}"></c:out></td>

                <c:if test="${user.role==\"ADMIN\"}">
                    <td><a href="/controller?command=loan&delete=true&id=${loan.id}">Delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
