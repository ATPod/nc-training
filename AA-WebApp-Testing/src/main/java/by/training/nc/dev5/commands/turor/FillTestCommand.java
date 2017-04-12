package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FillTestCommand  extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String testName=request.getParameter("testName");
        int questionAmount=Integer.parseInt(request.getParameter("questionAmount"));
        int optionAmount=Integer.parseInt(request.getParameter("optionAmount"));
        HttpSession session=request.getSession();
        session.setAttribute("testName",testName);
        session.setAttribute("questionAmount",questionAmount);
        session.setAttribute("optionAmount",optionAmount);
        return JspPaths.FILL_TEST_FORM;
    }
}
