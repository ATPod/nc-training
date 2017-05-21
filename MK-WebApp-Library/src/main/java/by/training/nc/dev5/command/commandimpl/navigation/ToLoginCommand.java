package by.training.nc.dev5.command.commandimpl.navigation;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class ToLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return ConstantsUtil.LOGIN_PAGE;
    }
}
