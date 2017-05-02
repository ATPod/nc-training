package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.jpaservice.LoanServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class LoansCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        LoanServiceJPA ls = new LoanServiceJPA();

        request.getSession().setAttribute("loans",ls.selectLoans());

        ls.selectLoans().forEach(System.out::println);

        return ConstantsUtil.LOANS_PAGE;
    }
}
