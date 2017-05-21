<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Результаты тестирования</title>
</head>
<body>
<div class="page-header" align="center"><h1>Результаты тестирования</h1></div>
<div class="row">
    <div class="col-md-3" align="left">
        <jsp:include page="student_navbar.jsp"/>
    </div>
    <div class="col-md-8" align="center">
        <h1>Результат: ${result} балл(ов)</h1>
        <h2>Ответы: ${questionAnswers}</h2>
    </div>
    </div>
</body>
</html>
