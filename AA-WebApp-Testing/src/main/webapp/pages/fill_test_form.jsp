<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Cache-Control" content="no-cache">
<html>
<head>
    <title>Заполнение данных для теста</title>
</head>
<body>
<form name="testsTable" method="POST" action="controller?command=AddTest">
    <input type="hidden" name="command" value="AddTest"/>
        <table border="1">
            <tr bgcolor="#afeeee" align="center">
                <td colspan="3">${testName}</td>
            </tr>
            <c:forEach begin="1" end="${questionAmount}" varStatus="counter1">
                <tr>
                <tr>
                    <td bgcolor="#afeeee">Текст вопроса ${counter1.current}:</td>
                    <td><input type="text" size="80" name="questionText${counter1.current}" value="" placeholder="Текст вопроса..."/></td>
                </tr>
                <c:forEach begin="1" end="${optionAmount}" varStatus="counter2">
                    <tr>
                        <td>Текст варианта:</td>
                        <td><input type="text" size="80" name="optionText${counter1.current}${counter2.current}" value="" placeholder="Текст варианта..."/></td>
                        <td align="center"><input type="checkbox" name="rightness${counter1.current}${counter2.current}" value="1"></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td bgcolor="#afeeee">Баллы за вопрос:</td>
                    <td><input type="text" size="10" name="questionBalls${counter1.current}" value=""/></td>
                </tr>
            </c:forEach>
            <tr ><td align="center" colspan="3"><button name="result" value="">Добавить тест</button></td></tr>
        </table>
</form>
</body>
</html>
