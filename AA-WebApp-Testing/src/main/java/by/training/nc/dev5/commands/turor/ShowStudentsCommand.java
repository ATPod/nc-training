package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.sql.SQLQueries;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowStudentsCommand extends AbstractCommand{
    @Override
    public String execute(HttpServletRequest request) {
        MySQLDAOFactory factory=new MySQLDAOFactory();
        InterfaceDAO<User> userDAO=factory.getUserDAO();
        List<User> students=userDAO.getAll(SQLQueries.FIND_STUDENTS,1);
        HttpSession session=request.getSession();
        session.setAttribute("students",students);
        return JspPaths.STUDENTS_LIST;
    }
}
