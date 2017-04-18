<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Операции</title>
</head>
<body>
<form name="chooseSurgeryForm" method="POST" action="controller">
    <input type="hidden" name="command" value="delSurgery" />
    Выберите операцию:
    <table border="1">
        <tr bgcolor="#CCCCCC">
            <td align="center"> </td>
            <td align="center"><strong>Операция</strong></td>
        </tr>
        <c:forEach var="surgery" items="${surgeriesList}">
            <tr>
                <td><input type="radio" name="surgeryId" value="${ surgery.id }"/></td>
                <td><c:out value="${ surgery.name }" /></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Выбрать"/>  <br/>
    <a href="controller?command=backtoinnermenu">Вернуться обратно</a><br/>
    <a href="controller?command=logout">Выйти из системы</a><br/><br/>
    ${operationMessage}  <br />
    ${errorEmptyChoice}<br />
    ${errorEmptyList} <br/>
</form>
</body>
</html>
