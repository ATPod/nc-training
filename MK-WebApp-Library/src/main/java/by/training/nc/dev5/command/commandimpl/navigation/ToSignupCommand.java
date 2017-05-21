package by.training.nc.dev5.command.commandimpl.navigation;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 01.05.2017.
 */
public class ToSignupCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return ConstantsUtil.SIGNUP_PAGE;
    }
}
