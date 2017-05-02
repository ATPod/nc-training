package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.CreditCard;
import by.training.nc.dev5.services.CreditCardService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AsusPC on 24.04.17.
 */
public class UnblockCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("cr_id");
        CreditCardService.unblockCreditCard(id);
        return JspPaths.SUCCESSED_OPERATION;
    }
}
