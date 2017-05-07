<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute
        name="tor"
        rtexprvalue="true"
        required="true"
        type="by.training.nc.dev5.entity.TermsOfReference" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>

<%--<div class="row">--%>
    <%--<div class="col-lg-12"><div class="text-center bg-info">${tor.id}</div></div>--%>
    <%--<c:forEach var="task" items="${tor.tasks}">--%>
        <%--<div class="col-lg-8">${task.specification}</div>--%>
        <%--<div class="col-lg-4">--%>
            <%--<c:forEach var="taskQuota" items="${task.taskQuotas}">--%>
            <%--<div class="row">--%>
                <%--<div class="col-lg-9">${taskQuota.qualification.name}:</div>--%>
                <%--<div class="col-lg-3">${taskQuota.developersNumber}</div>--%>
            <%--</div>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
    <%--</c:forEach>--%>
<%--</div>--%>
<tr class="active">
    <th colspan="3">#${tor.id}</th>
</tr>
<c:forEach var="task" items="${tor.tasks}">
    <tr>
        <td rowspan="${task.taskQuotas.size() + 1}">${task.specification}</td>
    </tr>
    <c:forEach var="taskQuota" items="${task.taskQuotas}">
        <tr>
            <td>${taskQuota.qualification.name}</td>
            <td>${taskQuota.developersNumber}</td>
        </tr>
    </c:forEach>
</c:forEach>