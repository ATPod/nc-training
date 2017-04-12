package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;
public class GoToClientRegistrationForm extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {

        return JspPaths.CLIENT_REGISTER_FORM;
    }
}
