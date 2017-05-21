<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <title>Прохождение теста</title>
</head>
<body>
<div >
    <form class="form-horizontal" name="testsTable" method="POST" action="${pageContext.request.contextPath}/showTest">
        <input type="hidden" name="testId" value="${test.id}"/>
        <input type="hidden" name="command" value="ShowResult"/>
        <fieldset>
            <legend align="center">${test.name}</legend>
            <div class="form-group">
                <c:forEach var="question" items="${test.questions}">
                    <div class="form-group">
                        <div class="col-md-11 col-md-offset-1">
                                ${question.text}
                        </div>
                    </div>
                    <c:forEach var="option" items="${question.answerOptions}">
                        <div class="form-group">
                            <div class="col-md-10">
                                <div class="col-md-1 col-md-offset-1">
                                        ${option.number}</div>
                                <div class="col-md-7">${option.text}</div>
                                <div class="col-md-2"><input type="checkbox" name="answer${option.id}" value="1"></div>
                            </div>
                        </div>
                    </c:forEach>
                </c:forEach>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton"></label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="result" class="btn btn-success">Отправить результат</button>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
