<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Settings</title>
    </head>
    <body>

        <a href="controller?command=client_go_to_orderings">My orderings</a> <br/>
        <a href="controller?command=client_go_to_bag">Bag</a> <br/>
        <a href="controller?command=client_go_to_main">Back</a> <br/>
        <a href="controller?command=logout">Log out</a> <br/><br/>

        <form name="firstNameForm" method="POST" action="controller">
            <input type="hidden" name="command" value="client_update_first_name"/>
            First name:<br/>
            <input type="text" name="firstname" value=""/><br/>
            <input type="submit" value="Update"/>
        </form>
        <form name="lastNameForm" method="POST" action="controller">
            <input type="hidden" name="command" value="client_update_last_name"/>
            Last name:<br/>
            <input type="text" name="lastname" value=""/><br/>
            <input type="submit" value="Update"/>
        </form>
        <form name="emailForm" method="POST" action="controller">
            <input type="hidden" name="command" value="client_update_email"/>
            E-mail:<br/>
            <input type="text" name="email" value=""/><br/>
            <input type="submit" value="Update"/>
        </form>
        <form name="passwordForm" method="POST" action="controller">
            <input type="hidden" name="command" value="client_update_password"/>
            Password:<br/>
            <input type="text" name="password" value=""/><br/>
            <input type="submit" value="Update"/>
        </form>

        ${blackListMessage}
        ${errorMessage}

    </body>
</html>

