<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}  /assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Доступные тесты</title>
</head>
<body>
<div class="page-header" align="center"><h1>Доступные тесты</h1></div>
<c:if test="${sessionUser.userType.equals('student')}">
    <div class="row">
        <div class="col-md-3" align="left">
            <jsp:include page="student_navbar.jsp"/>
        </div>
        <div class="col-md-8" align="center">
            <form name="testsTable" method="POST" action="${pageContext.request.contextPath}/showTest">
                <input type="hidden" name="command" value="ShowTest"/>
                <div class="form-group">
                    <div class="col-md-4" align="center"><b>Название теста</b></div>
                    <div class="col-md-4" align="center"><b>Предмет</b></div>
                    <div class="col-md-2" align="center">&nbsp;</div>
                </div>
                <c:forEach var="test" items="${tests}">
                    <div class="row">
                        <div class="col-md-4" align="center">${test.name}</div>
                        <div class="col-md-4" align="center">${test.subject}</div>
                        <div class="col-md-2">
                            <button value="${test.id}" name="testId" class="btn btn-success">Пройти тест</button>
                        </div>
                    </div>
                </c:forEach>
            </form>
        </div>
    </div>
</c:if>
<c:if test="${sessionUser.userType.equals('tutor')}">
    <div class="row">
        <div class="col-md-3" align="left">
            <jsp:include page="tutor_navbar.jsp"/>
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-4"><b>Название теста</b></div>
                <div class="col-md-4"><b>Предмет</b></div>
            </div>
            <c:forEach var="test" items="${tests}">
                <div class="row">
                    <div class="col-md-4">${test.name}</div>
                    <div class="col-md-4">${test.subject}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</c:if>
</body>
</html>
