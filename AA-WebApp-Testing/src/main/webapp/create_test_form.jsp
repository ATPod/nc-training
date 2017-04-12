<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 12.04.2017
  Time: 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заполнение параметров теста</title>
</head>
<body>
<form name="testCreation" method="POST"action="controller?command=FillTest">
    <input type="hidden" name="command" value="FillTest"/>
    <p><b>Введите параметры для нового теста </b></p>
    <table>
        <tr>
            <td>Название теста:</td>
            <td><input type="text" name="testName" value="" placeholder="Название теста..."/></td>
        </tr>
        <tr>
            <td>Количество вопросов:</td>
            <td><input type="text" name="questionAmount" value="" placeholder="Количество вопросов..."/></td>
        </tr>
        <tr>
            <td>Количество вариантов ответа в вопросе:</td>
            <td><input type="text" name="optionAmount" value="" placeholder="Количество вариантов..."/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>
