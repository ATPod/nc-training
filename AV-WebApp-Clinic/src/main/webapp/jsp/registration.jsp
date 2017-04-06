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
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" value="" size="20"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20" /></td>
        </tr>
        <tr>
            <td>Специальность: (врач - 1, медсестра - 2)</td>
            <td><input type="access_level" name="access_level" value="" size="20" /></td>
        </tr>
    </table>
    ${operationMessage}
    ${errorUserExists} <br />
    ${errorAccessLevel} <br />
    <input type="submit" value="Зарегистрировать" />
    <a href="controller?command=back">Вернуться обратно</a>
</form>


</body>
</html>