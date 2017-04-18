<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form name="registrationForm" method="POST" action="controller">
    <input type="hidden" name="command" value="registration" />
    Введите ваши данные:<br/>
    Логин:<br/>
    <input type="text" name="login" value="" size="20"/><br/>
    Пароль:<br/>
    <input type="password" name="password" value="" size="20" /><br/>
    Специальность:<br/>
    <input type="radio" name="access_level" value="DOCTOR"/>Врач<br/>
    <input type="radio" name="access_level" value="NURSE"/>Медсестра<br/>


    ${operationMessage}
    ${errorEmptyChoice}
    ${errorUserExists} <br />
    ${errorAccessLevel} <br />
    <input type="submit" value="Зарегистрировать" />
    <a href="controller?command=back">Вернуться обратно</a>
</form>
</body>
</html>