<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="UTF-8" %>
<%@ attribute
        name="project"
        type="by.training.nc.dev5.dto.ProjectDto" %>

<tr class="active"><td colspan="2">${project.id}</td></tr>
<tr><th>Name</th><th>Qualification</th></tr>
<c:forEach var="developer" items="${project.developers}">
    <!-- ${developer}; name=${developer.name}; ${developer.id} -->
    <tr><td>${developer.name}</td><td>${developer.qualification.name}</td></tr>
</c:forEach>