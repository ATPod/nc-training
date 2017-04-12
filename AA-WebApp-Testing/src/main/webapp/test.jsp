<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Прохождение теста</title>
</head>
<body>
<form name="testsTable" method="POST" action="controller?command=ShowResult">
    <input type="hidden" name="command" value="ShowResult"/>
    <table border="1">
        <tr bgcolor="#afeeee" align="center">
            <td colspan="3">${test.name}</td>
        </tr>
        <c:forEach var="question" items="${test.questions}">
            <tr bgcolor="#afeeee" align="center">
                <td colspan="3">${question.text}</td>
            </tr>
            <c:forEach var="option" items="${question.answerOptions}">
                <tr>
                    <td align="center">${option.number}</td>
                    <td align="left">${option.text}</td>
                    <td align="center"><input type="checkbox"></td>
                </tr>
            </c:forEach>
        </c:forEach>
        <tr ><td align="center" colspan="3"><button name="result" value="">Отправить результат</button></td></tr>
    </table>
</form>
</body>
</html>
