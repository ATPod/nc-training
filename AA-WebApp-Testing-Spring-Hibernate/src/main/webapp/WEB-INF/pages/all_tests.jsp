<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- безопасность на уровне представлений-->
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}  /assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title><spring:message code="page.tests.title"/></title>
</head>
<body>
<div class="page-header" align="center"><h1><spring:message code="page.tests.title"/></h1></div>
<!-- отображение формы ввода сооб-
щения, только если пользователь обладает определенной привилегией-->
<security:authorize access="hasRole('ROLE_STUDENT')">
    <jsp:include page="student_nav.jsp"/>
    <div class="col-md-12" align="center">
        <form name="testsTable" method="POST" action="${pageContext.request.contextPath}/showTest">
            <input type="hidden" name="command" value="ShowTest"/>
            <div class="form-group">
                <div class="col-md-4" align="center"><b><spring:message code="page.tests.test.name"/></b></div>
                <div class="col-md-4" align="center"><b><spring:message code="page.subject"/></b></div>
                <div class="col-md-2" align="center">&nbsp;</div>
            </div>
            <c:forEach var="test" items="${tests}">
                <div class="row">
                    <div class="col-md-4" align="center">${test.name}</div>
                    <div class="col-md-4" align="center">${test.subject}</div>
                    <div class="col-md-2">
                        <button value="${test.id}" name="testId" class="btn btn-success"><spring:message code="page.tests.test.button"/></button>
                    </div>
                </div>
            </c:forEach>
        </form>
    </div>
</security:authorize>
<security:authorize access="hasRole('ROLE_TUTOR')">
    <jsp:include page="tutor_nav.jsp"/>
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-4"><b><spring:message code="page.tests.test.name"/></b></div>
            <div class="col-md-4"><b><spring:message code="page.subject"/></b></div>
        </div>
        <c:forEach var="test" items="${tests}">
            <div class="row">
                <div class="col-md-4">${test.name}</div>
                <div class="col-md-4">${test.subject}</div>
            </div>
        </c:forEach>
    </div>
</security:authorize>
</body>
</html>
