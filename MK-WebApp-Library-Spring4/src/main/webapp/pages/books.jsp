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
<%@ page errorPage="error.jsp" %>
<div style="height: 50% ;
    overflow-y: auto;">
<table class="table" >
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Title</th>
        <c:if test="${user.role==\"ADMIN\"}">
            <th>Control</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:if test="${user!=null}">
        <c:forEach var="book" items="${books}" varStatus="index">
            <%-- <c:url var="deleteUrl" value="/controller?command=loan?delete=true?id=${loan.id}"/>--%>
            <tr>
                <td>${index.index+1}</td>
                <td><c:out value="${book.id}"></c:out></td>
                <td><c:out value="${book.title}"></c:out></td>
                <c:if test="${user.role==\"ADMIN\"}">
                    <td>
                        <form method="POST" action="/books/delete">
                            <input type="hidden" name="book-delete-id" value="${ book.id }"/>
                            <input type="submit" value="delete" class="btn btn-danger"/>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</div>
<div>
    <form action="/books/add" method="get">
        <button type="submit" class="btn btn-primary">Add Book</button>
    </form>
</div>

</body>
</html>
