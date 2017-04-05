package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Commands;

import javax.servlet.http.HttpServletRequest;
public class GoToTutorRegistrationForm extends AbstractCommand{
    //форма регистрации тьютора
    @Override
    public String execute(HttpServletRequest request) {
        return Commands.GOTOTUTORREGISTRATION.redirectJSP;
    }
}
