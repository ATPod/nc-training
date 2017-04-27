package by.training.nc.dev5.daoService;

import by.training.nc.dev5.dao.BookMySQLDAO;
import by.training.nc.dev5.dao.dao.BookDAO;
import by.training.nc.dev5.model.Book;

import java.util.Collection;

/**
 * Created by ASUS on 19.04.2017.
 */
public class BookService {

    BookDAO bd = new BookMySQLDAO();


    public int insertBook(Book pBook) {

        return this.bd.insertBook(pBook);
    }

    public boolean deleteBook(int id) {
        return bd.deleteBook(id);
    }

    public Book findBook(int id) {
        return this.bd.findBook(id);
    }

    public boolean updateBook(String pBookId) {
        return this.bd.updateBook(pBookId);
    }

    public Collection<Book> selectBooks() {
        return this.bd.selectBooks();
    }
}
