<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Регистрация</title>
    <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
</head>
<body>
    <div class="container">
        <div class="header" align="left">
            <%@include file="../views/elements/header.jsp" %>
        </div>
        <a href="/index">Вход в систему</a>>Регистрация<br/>
        <div align="center">
            <s:form method="post" modelAttribute="user" action="/registration">
                <table>
                    <tr>
                        <td>Логин:</td>
                        <td><s:input type="text" path="login" value="" size="20"/></td>
                    </tr>
                    <tr>
                        <td>Пароль:</td>
                        <td><s:input type="password" path="password" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Специальность:</td>
                        <td>
                            <s:radiobutton path="accessLevel" value="DOCTOR"/>Врач<br/>
                            <s:radiobutton path="accessLevel" value="NURSE"/>Медсестра
                        </td>
                    </tr>
                </table>
                <s:button>Зарегистрировать</s:button><br />
                ${operationMessage}<br />
            </s:form>
        </div>
        <div class="footer" align="center">
            <%@include file="../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>