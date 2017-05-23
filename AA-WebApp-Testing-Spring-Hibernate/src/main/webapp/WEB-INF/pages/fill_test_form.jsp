<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Заполнение данных для теста</title>
</head>
<body>
<div align="center">
    <sf:form class="form-horizontal" name="tutorRegistration" method="POST" modelAttribute="test"
             action="${pageContext.request.contextPath}/addTest">
        <fieldset>
            <legend>Заполнение данных для теста</legend>
            <label class="col-md-9">${test.name}</label>
            <div class="form-group">
                <c:forEach begin="1" end="${test.questions.size()}" varStatus="counter1">
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="question">Текст вопроса ${counter1.current}</label>
                        <div class="col-md-5">
                            <input id="question" name="questionText${counter1.current}" type="text" value=""
                                   placeholder="Текст вопроса..."
                                   class="form-control input-md" required="">
                        </div>
                    </div>
                    <c:forEach begin="1" end="${test.questions.get(0).answerOptions.size()}" varStatus="counter2">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="option">Текст варианта</label>
                            <div class="col-md-4">
                                <input id="option" name="optionText${counter1.current}${counter2.current}" type="text"
                                       value="" placeholder="Текст варианта..."
                                       class="form-control input-md" required="">
                            </div>
                            <div class="col-md-1" align="center"><input type="checkbox"
                                                                        name="rightness${counter1.current}${counter2.current}"
                                                                        value="1"></div>
                        </div>

                    </c:forEach>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="scores">Баллы за вопрос</label>
                        <div class="col-md-2">
                            <input id="scores" name="questionBalls${counter1.current}" type="text" value=""
                                   placeholder="Баллы..."
                                   class="form-control input-md" required="">
                        </div>
                    </div>
                </c:forEach>
            </div>
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
