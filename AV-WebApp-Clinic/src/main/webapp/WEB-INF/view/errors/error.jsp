<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Ошибка</title>
    <link href="../../../assets/css/page_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <div class="header">
            <%@include file="../../view/elements/header.jsp" %>
        </div>
        <a href="controller?command=backtologin">Вход в систему</a>>Страница ошибки<br/>
        Извините, но в данный момент сервис не доступен: <br/>
        ${operationMessage}<br />
        <div class="footer">
            <%@include file="../../view/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>