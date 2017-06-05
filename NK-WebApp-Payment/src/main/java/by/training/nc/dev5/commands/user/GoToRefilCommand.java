package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AsusPC on 18.04.17.
 */
public class GoToRefilCommand  extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        return JspPaths.REFIL_PATH;
    }
}
