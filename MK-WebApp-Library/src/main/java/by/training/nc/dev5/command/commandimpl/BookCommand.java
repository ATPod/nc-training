package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.entity.jpa.Book;
import by.training.nc.dev5.jpaservice.BookServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ASUS on 01.05.2017.
 */
public class BookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        BookServiceJPA bs = new BookServiceJPA();
        String toDo = request.getParameter("toDo");
        if(toDo.equals("addBook")){
            String title = request.getParameter("add-book-title");
            Book book = new Book();
            book.setTitle(title);
            bs.insertBook(book);
            ((List<Book>)request.getSession().getAttribute("books")).add(book);
            return ConstantsUtil.BOOKS_PAGE;
        }


        return null;
    }
}
