<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute
        name="terms"
        required="true"
        rtexprvalue="true"
        type="by.training.nc.dev5.dto.TermsOfReferenceDto" %>

<tr class="active">
    <th colspan="2">#${terms.id}</th>
    <security:authorize access="hasRole('ROLE_MANAGER')">
        <td>
            <c:url value="/manager/createProject" var="createProject" />
            <form:form method="post" action="${createProject}">
                <button type="submit"
                        class="btn btn-primary"
                        value="${terms.id}"
                        name="termsId">
                    Create Project
                </button>
            </form:form>
        </td>
    </security:authorize>
    <security:authorize url="/customer/">
        <td></td>
    </security:authorize>
</tr>
<!-- ${terms.tasks} -->
<c:forEach var="task" items="${terms.tasks}">
    <tr>
        <td rowspan="${task.quotas.size() + 1}">${task.specification}</td>
        <%--<td>Qualification</td>--%>
        <%--<td>Number</td>--%>
    </tr>
    <c:forEach var="quota" items="${task.quotas.entrySet()}">
        <tr>
            <td>${quota.key.name}</td>
            <td>${quota.value}</td>
        </tr>
    </c:forEach>
</c:forEach>