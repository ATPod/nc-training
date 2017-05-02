package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.jdbc.Book;

import java.util.Collection;


public interface BookDAO {

    int insertBook(Book book);
    boolean deleteBook(int id);
    Book findBook(int id);
    boolean updateBook(int id);
    Collection<Book> selectBooks();

}
