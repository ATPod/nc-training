package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        /*--stub--*/
        request.getSession().setAttribute("isLogged",false);

        request.getSession().setAttribute("user",null);
        /*--------*/
        //request.getSession().invalidate();
        return ConstantsUtil.INDEX_PAGE;
    }
}
