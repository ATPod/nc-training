package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowTestsCommand extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        MySQLDAOFactory factory=new MySQLDAOFactory();
        InterfaceDAO<Test> testDAO=factory.getTestDAO();
        List<Test> tests=testDAO.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("tests",tests);
        return JspPaths.TESTS;
    }
}
