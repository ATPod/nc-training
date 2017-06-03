<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute
        name="terms"
        required="true"
        rtexprvalue="true"
        type="by.training.nc.dev5.dto.TermsOfReferenceDto" %>

<tr class="active">
    <th colspan="3">#${terms.id}</th>
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