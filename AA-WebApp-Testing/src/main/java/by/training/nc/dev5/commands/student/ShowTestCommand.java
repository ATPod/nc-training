package by.training.nc.dev5.commands.student;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShowTestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int testId=Integer.parseInt(request.getParameter("testId"));
        MySQLDAOFactory factory=new MySQLDAOFactory();
        InterfaceDAO<Test> testDAO=factory.getTestDAO();
        HttpSession session=request.getSession();
        session.setAttribute("test",testDAO.find(testId));
        return JspPaths.TEST_TO_PASS;
    }
}
