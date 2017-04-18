<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Cache-Control" content="no-cache">
<html>
<head>
    <title>Регистрация тьютора</title>
</head>
<body>
<form name="registration" method="POST" action="controller?command=registertutor">
    <input type="hidden" name="command" value="RegisterTutor"/>
    <p><b>Введите данные тьютора: </b></p>
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" value="" size="20" placeholder="Введите логин..."/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" value="" size="20" placeholder="Введите пароль..."/></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="name" value="" size="20" placeholder="Введите имя..."/></td>
        </tr>
        <tr>
            <td>Фамилия :</td>
            <td><input type="text" name="surname" value="" size="20" placeholder="Введите фамилию..."/></td>
        </tr>
        <tr>
            <td>Предмет :</td>
            <td><input type="text" name="subject" value="" size="20" placeholder="Введите предмет..."/></td>
        </tr>
    </table>
    <input type="submit" value="Зарегистрировать"/>
</form>
</body>
</html>
