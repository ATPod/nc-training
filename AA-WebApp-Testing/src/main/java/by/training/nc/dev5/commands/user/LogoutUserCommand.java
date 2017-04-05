package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Commands;

import javax.servlet.http.HttpServletRequest;

public class LogoutUserCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return Commands.LOGOUTUSER.redirectJSP;
    }
}
