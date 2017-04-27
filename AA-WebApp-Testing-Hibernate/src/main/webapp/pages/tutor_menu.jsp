<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<html>
<body>
<div class="page-header" align="center"><h1>Профиль тьютора</h1></div>
<div class="col-md-3" align="left">
    <ul class="nav nav-list">
        <li><a href="controller?command=CreateTest">Добавить тест в систему</a></li>
        <li><a href="controller?command=ShowTests">Просмотреть список тестов</a></li>
        <li><a href="controller?command=ShowStudents">Просмотреть список студентов</a></li>
        <li><a href="controller?command=LogoutUser">Выйти из системы</a></li>
    </ul>
</div>
<div align="left" class="col-md-8">
    <h5>
        <p><b>Имя: </b>${user.name}</p>
        <p><b>Фамилия: </b>${user.surname}</p>
        <p><b>Преподаваемый предмет: </b>${user.subject}</p>
    </h5>
</div>
</body>
</html>
