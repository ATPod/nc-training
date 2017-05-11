<%@ tag body-content="empty"
        pageEncoding="utf-8" %>
<%@ attribute
        name="timeSheet"
        type="by.training.nc.dev5.dto.TimeSheetDto"
        rtexprvalue="true"
        required="true" %>

<tr>
    <td>${timeSheet.date}</td>
    <td>${timeSheet.project.id}</td>
    <td>${timeSheet.time}</td>
</tr>