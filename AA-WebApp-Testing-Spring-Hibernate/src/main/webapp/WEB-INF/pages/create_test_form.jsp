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
    <title><spring:message code="page.test.creation.title"/></title>
</head>
<body>
<jsp:include page="tutor_nav.jsp"/>
<div align="center">
    <sf:form class="form-horizontal" name="testCreation" method="POST" modelAttribute="testParameters" role="form" data-toggle="validator">
        <fieldset>
            <legend><spring:message code="page.test.creation.params"/></legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName"><spring:message code="page.test.creation.input.name"/></label>
                <div class="col-md-4">
                    <spring:message code="page.test.creation.input.name.placeholder" var="name_placeholder"/>
                    <spring:message code="test.name.format.error" var="test_name_error"/>
                    <sf:input id="testName" name="testName" type="text" value="" placeholder="${name_placeholder}"
                              class="form-control input-md" path="testName"
                              pattern="(\b[a-zA-Zа-яА-Я]+ *)+"
                              data-minlength="1"
                              data-error="${test_name_error}"/>
                              <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="questionAmount"><spring:message code="page.test.creation.input.questions"/></label>
                <div class="col-md-4">
                    <spring:message code="page.test.creation.input.questions.placeholder" var="question_placeholder"/>
                    <spring:message code="question.amount.format.error" var="question_number_error"/>
                    <sf:input id="questionAmount" name="questionAmount" type="text" value=""
                              placeholder="${question_placeholder}"
                              class="form-control input-md" path="questionAmount"
                              data-error="${question_number_error}"
                              pattern="[1-9]([0-9])*"/>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="testName"><spring:message code="page.test.creation.input.options"/></label>
                <div class="col-md-4">
                    <spring:message code="page.test.creation.input.options.placeholder" var="option_placeholder"/>
                    <spring:message code="option.amount.format.error" var="option_number_error"/>
                    <sf:input id="optionAmount" name="optionAmount" type="text" value=""
                              placeholder="${option_placeholder}"
                              class="form-control input-md"
                              path="optionAmount"
                              data-error="${option_number_error}"
                              pattern="[1-9]([0-9])*"
                    />
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success"><spring:message code="page.test.creation.button"/></button>
                </div>
            </div>
        </fieldset>
    </sf:form>
</div>
</body>
</html>
