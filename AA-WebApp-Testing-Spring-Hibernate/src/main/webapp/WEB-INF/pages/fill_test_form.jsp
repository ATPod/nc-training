<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/validator.min.js"></script>
    <title><spring:message code="page.form.test.fill.title"/></title>
</head>
<body>
<div align="center">
    <form class="form-horizontal" name="tutorRegistration" method="POST"
             action="${pageContext.request.contextPath}/addTest" role="form" data-toggle="validator">
        <fieldset>
            <legend><spring:message code="page.form.test.fill.title"/></legend>
            <label class="col-md-9">${testName}</label>
            <div class="form-group">
                <c:forEach begin="1" end="${questionAmount}" varStatus="counter1">
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="question"><spring:message code="page.form.test.fill.question"/> ${counter1.current}</label>
                        <div class="col-md-5">
                            <input id="question" name="questionText${counter1.current}" type="text" value=""
                                   placeholder="Текст вопроса..."
                                   class="form-control input-md" required="required"
                                   data-minlength="1"
                                   data-error="Текст вопроса должен иметь длину более одного символа и состоять из букв"
                            >
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                    <c:forEach begin="1" end="${optionAmount}" varStatus="counter2">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="option"><spring:message code="page.form.test.fill.option"/></label>
                            <div class="col-md-4">
                                <input id="option" name="optionText${counter1.current}${counter2.current}" type="text"
                                       value="" placeholder="Текст варианта..."
                                       class="form-control input-md" required="required" data-minlength="1"
                                data-error="Текст варианта ответа должен иметь длину более одного символа и состоять из букв">
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="col-md-1" align="center"><input type="checkbox"
                                                                        name="rightness${counter1.current}${counter2.current}"
                                                                        value="1"></div>
                        </div>

                    </c:forEach>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="scores"><spring:message code="page.form.test.fill.scores"/></label>
                        <div class="col-md-2">
                            <input id="scores" name="questionBalls${counter1.current}" type="text" value=""
                                   placeholder="Баллы..."
                                   class="form-control input-md" required="required"
                            pattern="[0-9]+"
                            data-minlength="1"
                            data-error="Неверный формат ввода для числа баллов">
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success"><spring:message code="page.form.test.fill.button"/></button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
