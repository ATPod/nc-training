package by.training.nc.dev5.commands.turor;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;

public class CreateTestCommand  extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return JspPaths.CREATE_TEST;
    }
}
