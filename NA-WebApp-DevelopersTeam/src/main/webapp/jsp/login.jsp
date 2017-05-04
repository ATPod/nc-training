<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="text-center">
            <form method="post" name="loginForm" action="controller">
                <input type="hidden" name="command" value="login">
                <div class="form-group">
                    <label>
                        User name:<br />
                        <input type="text" class="form-control" name="username"><br />
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        Password:<br />
                        <input type="password" class="form-control" name="password"><br />
                    </label>
                </div>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </form>
        </div>
    </div>

    <div style="color: red">
        ${requestScope.loginErrorMessage}
    </div>
</body>
</html>
