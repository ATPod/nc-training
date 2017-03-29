package by.training.nc.dev5.dao;

import by.training.nc.dev5.model.Book;

import java.util.Collection;


public interface BooksDAO {

    int insertBook(Book pBook);
    boolean deleteBook(int id);
    Book findBook(String pBookId);
    boolean updateBook(String pBookId);
    Collection<Book> selectBooks();

}
