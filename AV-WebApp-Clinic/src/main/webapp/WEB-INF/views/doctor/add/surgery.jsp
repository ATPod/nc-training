<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление операции</title>
    <link href="../../../../assets/css/page_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../../../views/elements/header.jsp" %>
        </div>
        <a href="controller?command=backtologin">Вход в систему</a>>
        <a href="controller?command=backtochoosepatient">Выбор карточки пациента</a>>
        <a href="controller?command=backtomenu">Карточка пациента</a>>Добавление операции<br/>
        <div align="center">
            <form name="addSurgeryForm" method="POST" action="controller">
                <input type="hidden" name="command" value="addSurgery" />
                Введите название:<br />
                <input type="text" name="surgeryName" value="" />
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
