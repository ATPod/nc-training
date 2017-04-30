package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.StudentService;

import javax.servlet.http.HttpServletRequest;

public class RegisterStudentCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        StudentService studentService=StudentService.getInstance();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setPassword(password);
        student.setLogin(login);
        studentService.addEntity(student);
        return JspPaths.LOGIN_PAGE_PATH;
    }
}
