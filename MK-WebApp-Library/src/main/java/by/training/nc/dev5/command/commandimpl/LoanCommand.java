package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.entity.jpa.Book;
import by.training.nc.dev5.jpaservice.LoanServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 01.05.2017.
 */
public class LoanCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        System.out.println("in loan controller");

        System.out.println(" info :  "+request.getParameter("command")+" "+ request.getParameter("id")+" "
                                +request.getParameter("delete") );

        LoanServiceJPA ls = new LoanServiceJPA();
        if(request.getParameter("delete").equals("true")){
            ls.deleteLoan(Integer.valueOf(request.getParameter("id")));

        }
        if(request.getParameter("toDo").equals("addLoan")){
            String title = request.getParameter("loan-book");

            Book book = new Book();
            book.setTitle(title);
            //bs.insertBook(book);
            //((List<Book>)request.getSession().getAttribute("books")).add(book);
            return ConstantsUtil.BOOKS_PAGE;
        }


        return ConstantsUtil.LOANS_PAGE;
    }
}
