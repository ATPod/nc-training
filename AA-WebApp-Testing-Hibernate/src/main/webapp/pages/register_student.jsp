<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <title>Регистрация студента</title>
</head>
<body>
<div align="center">
    <font color="#8b0000"><b>${error_message}</b></font>
    <form class="form-horizontal" name="studentRegistration" method="POST" action="controller?command=RegisterStudent">
        <input type="hidden" name="command" value="RegisterStudent"/>
        <fieldset>
            <legend>Регистрация студента</legend>
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="" placeholder="Введите логин..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Пароль</label>
                <div class="col-md-4">
                    <input id="Password" name="password" type="password" value="12345" placeholder=""
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Имя</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" value="" placeholder="Введите имя..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Фамилия</label>
                <div class="col-md-4">
                    <input id="surname" name="surname" type="text" value="" placeholder="Введите фамилию..."
                           class="form-control input-md" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
