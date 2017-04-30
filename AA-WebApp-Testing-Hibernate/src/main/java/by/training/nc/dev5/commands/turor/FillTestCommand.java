package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.ValidationService;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FillTestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ValidationService validationService = ValidationService.getInstance();
        String testName = request.getParameter("testName");
        String questionAmount = request.getParameter("questionAmount");
        String optionAmount = request.getParameter("optionAmount");
        if (validationService.isStringNumberValid(questionAmount) && validationService.isStringNumberValid(optionAmount)) {
            session.setAttribute("questionAmount", Integer.parseInt(questionAmount));
            session.setAttribute("optionAmount", Integer.parseInt(optionAmount));
            session.setAttribute("testName", testName);
            return JspPaths.FILL_TEST_FORM;
        } else {
            request.setAttribute("error_message", "Неверный ввод!");
            return JspPaths.CREATE_TEST;
        }
    }
}
