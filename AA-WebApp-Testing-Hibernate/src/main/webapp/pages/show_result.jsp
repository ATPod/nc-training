<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
