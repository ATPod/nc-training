package by.training.nc.dev5.commands.user;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowTestsCommand extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        TestService testService=TestService.getInstance();
        HttpSession session = request.getSession();
        session.setAttribute("tests",testService.getAll());
        return JspPaths.TESTS;
    }
}
