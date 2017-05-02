package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.entity.jpa.Book;
import by.training.nc.dev5.jpaservice.BookServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class BooksCommand implements Command {

    private static List<Book> books;
    @Override
    public String execute(HttpServletRequest request) {

        BookServiceJPA bs = new BookServiceJPA();
        if(request.getSession().getAttribute("book")==null) {
            books = bs.selectBooks();
        }
        request.getSession().setAttribute("books", books);
        bs.selectBooks().forEach(System.out::println);

        return ConstantsUtil.BOOKS_PAGE;
    }
}
