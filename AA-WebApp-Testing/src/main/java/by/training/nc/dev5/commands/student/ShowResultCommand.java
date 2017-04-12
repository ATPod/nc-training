package by.training.nc.dev5.commands.student;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

public class ShowResultCommand extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return JspPaths.SHOW_RESULT;
    }
}
