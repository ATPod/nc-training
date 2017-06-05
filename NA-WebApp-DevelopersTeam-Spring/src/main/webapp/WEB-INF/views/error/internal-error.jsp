<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>500 Internal server error</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <c:url var="home" value="/home" />

    <div class="container">
        <h2>Internal server error has occurred</h2>
        <p>If you are reading this, then something unexpected has happened. Be sure
            that we are doing our best to find out why you see this.</p>
        <a href="${home}">Back to home page</a>
    </div>

    <!--
        Failed URL: ${url}
        Exception:  ${exception.message}
            <c:forEach items="${exception.stackTrace}" var="ste">    ${ste}
        </c:forEach>
    -->
</body>
</html>
