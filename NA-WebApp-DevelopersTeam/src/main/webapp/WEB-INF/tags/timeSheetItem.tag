<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute
        name="timeSheet"
        type="by.training.nc.dev5.dto.TimeSheetDto"
        rtexprvalue="true"
        required="true" %>

<tr>
    <td><fmt:formatDate type="date" value="${timeSheet.date}" /></td>
    <td>${timeSheet.developer.name}</td>
    <td>${timeSheet.project.id}</td>
    <td>${timeSheet.time}</td>
</tr>