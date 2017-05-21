<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h2>List of Employees</h2>
<table>
    <tr>
        <td>First Name</td><td>Last Name</td>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>
