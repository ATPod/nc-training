package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

public class GoToLoginCommand extends AbstractCommand  implements Command {
    public String execute(HttpServletRequest request) {
        return JspPaths.LOGIN_PAGE_PATH;
    }
}