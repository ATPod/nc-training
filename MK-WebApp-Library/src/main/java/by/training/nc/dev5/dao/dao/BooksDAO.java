package by.training.nc.dev5.dao.dao;

import by.training.nc.dev5.model.Book;

import java.util.Collection;


public interface BooksDAO {

    int insertBook(Book pBook);
    boolean deleteBook(int id);
    Book findBook(int id);
    boolean updateBook(String pBookId);
    Collection<Book> selectBooks();

}
