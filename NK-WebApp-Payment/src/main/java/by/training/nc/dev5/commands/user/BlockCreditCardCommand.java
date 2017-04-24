package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AsusPC on 24.04.17.
 */
public class BlockCreditCardCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("cr_id");
        String password = request.getParameter("cr_password");
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        CreditCard creditCard = creditCardMySQLDAO.findCreditCard(id);
        if(creditCard.getPassword().equals(password)){
            creditCard.getAccount().setBlocked(true);
            creditCardMySQLDAO.updateCreditCard(creditCard);
            return JspPaths.SUCCESSED_OPERATION;
        }
        request.setAttribute("error_message", "invalid password");
        return null;
    }
}
