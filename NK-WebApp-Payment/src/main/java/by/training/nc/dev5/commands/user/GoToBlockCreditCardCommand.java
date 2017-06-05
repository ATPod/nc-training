package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.services.CreditCardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AsusPC on 24.04.17.
 */
public class GoToBlockCreditCardCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        session.setAttribute("creditCards", CreditCardService.showYourCreditCards(person));
        return JspPaths.BLOCK_PATH;
    }
}