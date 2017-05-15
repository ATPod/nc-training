<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление лекарства</title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../../views/elements/header.jsp" %>
        </div>
        <a href="/login">Вход в систему</a>>
        <a href="/choosepatient">Выбор карточки пациента</a>>
        <a href="/doctormenu">Карточка пациента</a>>Добавление лекарства<br/>
        <div align="center">
            <form name="addDrugForm" method="POST" action="/adddrug">
                Введите название:<br />
                <input type="text" name="drugName" value="" />
                <input type="submit" value="Сохранить" /> <br />
                ${operationMessage}  <br />
            </form>
        </div>
        <div class="footer" align="center">
            <%@include file="../../../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>
