<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Ошибка</title>
</head>
<body>
<div align="center">
    <h1>ПРОИЗОШЛА ОШИБКА!</h1>
    ${errorMessage}
    <button id="singlebutton" name="singlebutton" class="btn btn-success" href="${pageContext.request.contextPath}/home">На главную</button>
</div>
</body>
</html>
