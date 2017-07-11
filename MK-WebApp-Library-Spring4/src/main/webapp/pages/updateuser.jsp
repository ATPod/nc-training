<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<jsp:include page="navbar.jsp"></jsp:include>
<body>
<br>
<br>
<div class="container-fluid">
    <div class="panel panel-success">
        <div class="panel-heading" align="center">
            <h4>Update user</h4>
        </div>
        <div class="panel-body"align="center">
            <div class="container " style=" margin-bottom: 10%;">
                <div class="panel panel-success" style="max-width: 35%;" align="left">
                    <div class="panel-body" >
                        <form name="loan-form" action="/users/update" method="post"  >
                            <div class="form-group">
                                <label>Select user</label>
                                <select class="form-control" name="user-update-id" id="user-update">
                                    <c:forEach var="user" items="${users}" varStatus="index">
                                        <option  value="${user.id}"><c:out value="${user.name}"></c:out></option>
                                    </c:forEach>
                                </select>
                                <label>New username</label>
                                <div>
                                <input type="text" name="user-new-name" class="form-control" required placeholder="enter new name">
                                </div>
                            </div>
                            <button type="submit" style="width: 100%;" class="btn btn-large btn btn-success btn-lg btn-block"><b>Update</b></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
