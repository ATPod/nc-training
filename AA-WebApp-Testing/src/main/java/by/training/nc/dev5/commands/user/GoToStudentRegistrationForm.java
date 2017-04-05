package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;
public class GoToStudentRegistrationForm extends AbstractCommand{
    //форма регистрации студента
    @Override
    public String execute(HttpServletRequest request) {

        return JspPaths.STUDENT_REGISTER_FORM;
    }
}
