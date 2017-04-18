package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Account;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.exceptions.NotCorrectIdException;
import by.training.nc.dev5.exceptions.NotCorrectPasswordException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AsusPC on 18.04.17.
 */
public class DeleteCreditCardCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("cr_id");
        String password = request.getParameter("cr_password");
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        try {
            CreditCard creditCard = new CreditCard(id, password, null, person.getId());
            creditCardMySQLDAO.deleteCreditCard(creditCard);
            return JspPaths.SUCCESSED_OPERATION;
        } catch (NotCorrectIdException e){
            request.setAttribute("error_message", "invalid id");
        } catch (NotCorrectPasswordException e){
            request.setAttribute("error_message", "invalid password");
        }
        return null;
    }
}
