<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <!--BootstrapValidator - это jQuery-плагин
    для валидации полей формы, используется совместно с Bootstrap 3-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/validator.min.js"></script>
    <title>Title</title>
</head>
<body>
<form role="form" data-toggle="validator">
    <div class="form-group">
        <label for="inputName" class="control-label">Name</label>
        <input type="text" class="form-control" id="inputName" placeholder="Cina Saffary" required>
    </div>
    <div class="form-group">
        <label for="inputEmail" class="control-label">Email</label>
        <input type="email" class="form-control" id="inputEmail" placeholder="Email"
               data-error="Bruh, that email address is invalid" required>
        <div class="help-block with-errors"></div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="control-label">Password</label>
        <div class="form-inline row">
            <div class="form-group col-sm-6">
                <input type="password" data-minlength="6" class="form-control" id="inputPassword" placeholder="Password"
                       required>
                <div class="help-block">Minimum of 6 characters</div>
            </div>
            <div class="form-group col-sm-6">
                <input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword"
                       data-match-error="Whoops, these don't match" placeholder="Confirm" required>
                <div class="help-block with-errors"></div>
            </div>
        </div>
    </div>

    <button id="save" type="button" class="btn btn-primary" onclick=$('form').validator()>Регистрация</button>
</form>

</body>
</html>
