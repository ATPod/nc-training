<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <title>Заполнение параметров теста</title>
</head>
<body>
<div align="center">
    <form class="form-horizontal" name="testCreation" method="POST" action="controller?command=FillTest">
        <input type="hidden" name="command" value="FillTest"/>
        <font color="#8b0000"><b>${error_message}</b></font>
        <fieldset>
            <legend>Введите параметры для нового теста</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName">Название теста</label>
                <div class="col-md-4">
                    <input id="testName" name="testName" type="text" value="" placeholder="Введите название теста..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="questionAmount">Количество вопросов</label>
                <div class="col-md-4">
                    <input id="questionAmount" name="questionAmount" type="text" value="" placeholder="Введите количество вопросов..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName">Количество вариантов</label>
                <div class="col-md-4">
                    <input id="optionAmount" name="optionAmount" type="text" value="" placeholder="Количество вариантов ответа..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Подтвердить</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
