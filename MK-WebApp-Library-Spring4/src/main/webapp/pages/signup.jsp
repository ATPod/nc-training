<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<body>
<div class="container-fluid">
    <div class="panel panel-success">
        <div class="panel-heading" align="center">
            <h4>Sign Up</h4>
        </div>
        <div class="panel-body"align="center">
            <div class="container " style=" margin-bottom: 10%;">
                <div class="panel panel-success" style="max-width: 35%;" align="left">
                    <div class="panel-body" >
                        <form name="loginForm" action="/signup" method="post"  >
                            <div class="form-group">
                                <label >User Name</label>
                                <input type="text" class="form-control" name="user-name" id="user-name-id"
                                    placeholder="User Name" required="required">
                            </div>
                            <div class="form-group">
                                <label >Password</label>
                                <input type="password" class="form-control" name="user-password" id="user-password-id"
                                    placeholder="Password" required="required">
                            </div>
                            <div class="form-group">
                                <label>Role</label>
                                <select class="form-control" name="user-role" id="user-role-id">
                                    <option>USER</option>
                                    <option>ADMIN</option>
                                </select>
                            </div>
                            <button type="submit" style="width: 100%;" class="btn btn-large btn-primary btn-lg btn-block"><b>Sign Up</b></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
