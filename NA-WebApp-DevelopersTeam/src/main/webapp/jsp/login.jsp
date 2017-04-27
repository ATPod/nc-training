<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
    <form method="post" name="loginForm" action="controller">
        <input type="hidden" name="command" value="login">
        <label>
            User name:<br />
            <input type="text" name="username"><br />
        </label>
        <label>
            Password:<br />
            <input type="password" name="password"><br />
        </label>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>

    <div style="color: red">
        ${requestScope.loginErrorMessage}
    </div>
</body>
</html>
