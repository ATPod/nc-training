<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Добавление процедуры</title>
    <link href="../../../assets/css/page_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <div class="header">
            <%@include file="../../../view/elements/header.jsp" %>
        </div>
        <a href="controller?command=backtologin">Вход в систему</a>>
        <a href="controller?command=backtochoosepatient">Выбор карточки пациента</a>>
        <a href="controller?command=backtomenu">Карточка пациента</a>>Добавление процедуры<br/>
        <form name="addMedProcedureForm" method="POST" action="controller">
            <input type="hidden" name="command" value="addMedProcedure" />
            Введите название:<br />
            <input type="text" name="medProcedureName" value="" />
            <input type="submit" value="Сохранить" /> <br />
            ${operationMessage}  <br />
        </form>
        <div class="footer">
            <%@include file="../../../view/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>
