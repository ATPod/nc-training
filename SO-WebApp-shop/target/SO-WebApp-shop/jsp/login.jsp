<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form name="loginForm" method="POST" action="controller">
            <input type="hidden" name="command" value="login"/>
            E-mail:<br/>
            <input type="text" name="email" value=""/><br/>
            Password:<br/>
            <input type="password" name="password" value=""/><br/>
            <input type="submit" value="Log in"/>
        </form>

        <form name="reg" method="POST" action="controller">
            <input type="hidden" name="command" value="go_to_registration"/>
            <input type="submit" value="Sign up"/>
        </form>
        ${errorMessage}
    </body>
</html>