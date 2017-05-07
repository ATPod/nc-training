<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
    <head>
        <title>Авторизация</title>
        <link href="assets/css/page_style.css" rel="stylesheet" type="text/css">
        <link href="assets/css/logo_style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="header" align="left">
                <%@include file="WEB-INF/view/elements/header.jsp" %>
            </div>
            <div align="center">
                <form name="loginForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="login" />
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
                    <a href="controller?command=gotoregistration">Регистрация</a><br />
                    ${operationMessage}<br />
                </form>
            </div>
            <div class="footer" align="center">
                <%@include file="WEB-INF/view/elements/footer.jsp" %>
            </div>
        </div>
    </body>
</html>