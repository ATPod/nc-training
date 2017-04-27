package by.training.nc.dev5.commands.student;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.StudentService;
import by.training.nc.dev5.services.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowTestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        TestService testService=TestService.getInstance();
        int testId=Integer.parseInt(request.getParameter("testId"));
        HttpSession session=request.getSession();
        session.setAttribute("test",testService.findById(testId));
        return JspPaths.TEST_TO_PASS;
    }
}
