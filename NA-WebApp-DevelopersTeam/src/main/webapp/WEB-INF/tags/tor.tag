<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute
        name="tor"
        rtexprvalue="true"
        required="true"
        type="by.training.nc.dev5.entity.TermsOfReference" %>

<div class="row">
    <div class="col-lg-12"><div class="text-center">${tor.id}</div></div>
    <c:forEach var="task" items="${tor.tasks}">
        <div class="col-lg-8">${task.specification}</div>
        <div class="col-lg-4">
            <c:forEach var="taskQuota" items="${task.taskQuotas}">
            <div class="row">
                <div class="col-lg-9">${taskQuota.qualification.name}:</div>
                <div class="col-lg-3">${taskQuota.developersNumber}</div>
            </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>