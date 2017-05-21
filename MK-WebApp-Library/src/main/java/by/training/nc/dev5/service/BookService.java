package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.BookDAO;
import by.training.nc.dev5.dao.daoimpl.BookMySQLDAO;
import by.training.nc.dev5.entity.jdbc.Book;

import java.util.Collection;

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

    public boolean updateBook(int id) {
        return this.bd.updateBook(id);
    }

    public Collection<Book> selectBooks() {
        return this.bd.selectBooks();
    }
}
