<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
        <a href="controller?command=backtologin">Вход в систему</a>>Регистрация<br/>
        <div align="center">
            <form name="registrationForm" method="POST" action="controller">
                <input type="hidden" name="command" value="registration" />
                <table>
                    <tr>
                        <td>Логин:</td>
                        <td><input type="text" name="login" value="" size="20"/></td>
                    </tr>
                    <tr>
                        <td>Пароль:</td>
                        <td><input type="password" name="password" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Специальность:</td>
                        <td>
                            <input type="radio" name="access_level" value="DOCTOR"/>Врач<br/>
                            <input type="radio" name="access_level" value="NURSE"/>Медсестра
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Зарегистрировать" /> <br />
                ${operationMessage}<br />
            </form>
        </div>
        <div class="footer" align="center">
            <%@include file="../views/elements/footer.jsp" %>
        </div>
    </div>
</body>
</html>