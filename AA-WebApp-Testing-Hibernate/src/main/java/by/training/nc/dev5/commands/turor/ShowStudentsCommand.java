package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.StudentService;

import javax.servlet.http.HttpServletRequest;

public class ShowStudentsCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        StudentService studentService = StudentService.getInstance();
        request.setAttribute("students", studentService.getAll());
        return JspPaths.STUDENTS_LIST;
    }
}
