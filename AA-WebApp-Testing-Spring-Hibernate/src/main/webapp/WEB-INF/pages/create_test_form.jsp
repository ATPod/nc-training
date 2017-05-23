<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Заполнение параметров теста</title>
</head>
<body>
<div align="center">
    <sf:form class="form-horizontal" name="testCreation" method="POST" modelAttribute="testParameters">
        <fieldset>
            <legend>Введите параметры для нового теста</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName">Название теста</label>
                <div class="col-md-4">
                    <sf:input id="testName" name="testName" type="text" value="" placeholder="Введите название теста..."
                              class="form-control input-md" required="" path="testName"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="questionAmount">Количество вопросов</label>
                <div class="col-md-4">
                    <sf:input id="questionAmount" name="questionAmount" type="text" value=""
                              placeholder="Введите количество вопросов..."
                              class="form-control input-md" required="" path="questionAmount"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName">Количество вариантов</label>
                <div class="col-md-4">
                    <sf:input id="optionAmount" name="optionAmount" type="text" value=""
                              placeholder="Количество вариантов ответа..."
                              class="form-control input-md" required="" path="optionAmount"/>
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
    </sf:form>
</div>
</body>
</html>
