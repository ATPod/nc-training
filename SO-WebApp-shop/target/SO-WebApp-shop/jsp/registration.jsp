<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 15.04.2017
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <form name="registrationForm" method="POST" action="controller">
            <input type="hidden" name="command" value="register"/>
            First name:<br/>
            <input type="text" name="firstname" value=""/><br/>
            Last name:<br/>
            <input type="text" name="lastname" value=""/><br/>
            E-mail:<br/>
            <input type="text" name="email" value=""/><br/>
            Password:<br/>
            <input type="password" name="password" value=""/><br/>
            <input type="submit" value="Register"/>
        </form>
    ${errorMessage}
    </body>
</html>
