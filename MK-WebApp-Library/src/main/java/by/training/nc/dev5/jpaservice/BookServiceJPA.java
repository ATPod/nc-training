package by.training.nc.dev5.jpaservice;

import by.training.nc.dev5.entity.jpa.Book;
import by.training.nc.dev5.jpa.BookJPA;

import java.util.List;

/**
 * Created by ASUS on 02.05.2017.
 */
public class BookServiceJPA {

    BookJPA bjpa = new BookJPA();

    public Book insertBook(Book book){

        return bjpa.insertBook(book);
    }

    public List<Book> selectBooks(){

        return bjpa.selectBooks();
    }

}
