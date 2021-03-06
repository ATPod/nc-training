package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.services.CreditCardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by AsusPC on 18.04.17.
 */
public class InsertCreditCardCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("cr_id");
        String password = request.getParameter("cr_password");
        double money = Double.parseDouble(request.getParameter("money"));
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        String err = CreditCardService.insertCreditCard(id,password,money,person);
        if(err == null){
            return JspPaths.SUCCESSED_OPERATION;
        }else {
            request.setAttribute("error_message",err);
        }
        return null;
    }
}
