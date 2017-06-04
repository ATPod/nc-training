<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute
        name="parameterName"
        type="java.lang.String" %>
<%@ attribute
        name="projectsList"
        required="true"
        rtexprvalue="true"
        type="java.lang.Iterable" %>

<label for="__projectSelect__">Project:</label>
<select class="form-control" name="projectId" id="__projectSelect__">
    <c:forEach var="project" items="${projectsList}">
        <option value="${project.id}">#${project.id}</option>
    </c:forEach>
</select>