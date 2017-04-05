package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

public class GoToRegistration extends AbstractCommand {
    //переход на страницу регистрации
    public String execute(HttpServletRequest request) {
        return JspPaths.REGISTRATION_PAGE_PATH;
    }
}
