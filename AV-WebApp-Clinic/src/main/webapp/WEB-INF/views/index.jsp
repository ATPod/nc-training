<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
    <head>
        <title>Авторизация</title>
        <link href="${pageContext.request.contextPath}/resources/css/page_style.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/resources/css/logo_style.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container">
            <div class="header" align="left">
                <%@include file="elements/header.jsp" %>
            </div>
            <div align="center">
                <form name="loginForm" method="POST" action="/login">
                    <table>
                        <tr>
                            <td>Логин:</td>
                            <td><input type="text" name="login" value="" size="20"/></td>
                        </tr>
                        <tr>
                            <td>Пароль:</td>
                            <td><input type="password" name="password" value="" size="20" /></td>
                        </tr>
                    </table>
                    <input type="submit" value="Войти" />
                    <a href="/registration">Регистрация</a><br />
                    ${operationMessage}<br />
                </form>
            </div>
            <div class="footer" align="center">
                <%@include file="elements/footer.jsp" %>
            </div>
        </div>
    </body>
</html>