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
        String err = CreditCardService.moneyOperation(id,password,money,2);
        if(err == null){
            return JspPaths.SUCCESSED_OPERATION;
        }else {
            request.setAttribute("error_message",err);
        }
        return null;
    }
}
