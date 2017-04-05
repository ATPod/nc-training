package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

public class GoToLoginCommand extends AbstractCommand {
    //переход на страницу логина
    @Override
    public String execute(HttpServletRequest request) {

        return JspPaths.LOGIN_PAGE_PATH;
    }
}
