<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute name="parameterName" type="java.lang.String" %>

<jsp:useBean
        id="projectService"
        scope="page"
        type="by.training.nc.dev5.service.ProjectService"
        class="by.training.nc.dev5.service.ProjectServiceImpl" />

<label for="__projectSelect__">Project:</label>
<select class="form-control" name="projectId" id="__projectSelect__">
    <c:forEach var="project" items="${projectService.getProjectsByManager(sessionScope.user)}">
        <option value="${project.id}">#${project.id}</option>
    </c:forEach>
</select>