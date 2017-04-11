<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="POST"action="controller?command=Login">
    <input type="hidden" name="command" value="Login"/>
    <p><b>Вход в систему: </b></p>
    <div>
        <div>
            <div>Name:</div>
            <div><input type="text" name="login" value="" size="15" placeholder="Name"/></div>
        </div>
        <div>
            <div>Password:</div>
            <div><input type="password" name="password" value="" size="15" placeholder="Password"/></div>
        </div>
    </div>
    <input type="submit" value="Enter"/>
</form>
</body>
</html>
