package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.ClientMySQLDAO;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.services.CreditCardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AsusPC on 17.04.17.
 */
public class MakePayment extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("cr_id");
        String password = request.getParameter("cr_password");
        double money = Double.parseDouble(request.getParameter("money"));
        MySQLDAOFactory factory = new MySQLDAOFactory();
        CreditCardMySQLDAO creditCardMySQLDAO = new CreditCardMySQLDAO();
        CreditCard creditCard = new CreditCard(creditCardMySQLDAO.findCreditCard(id));
        if (creditCard != null) {
            HttpSession session = request.getSession();
            if(creditCard.getPassword().equals(password)) {
                if(creditCard.getAccount().getMoney() >= money) {
                    CreditCardService.moneyOperation(creditCard,password,money,2);
                    creditCardMySQLDAO.updateCreditCard(creditCard);
                    session.setAttribute("creditCard", creditCard);
                    return JspPaths.SUCCESSED_OPERATION;
                }
                else request.setAttribute("error_message", "not enough money");
            }
            else request.setAttribute("error_message", "invalid password");
        }
        else request.setAttribute("error_message", "no such credit cards");
        return null;
    }
}
