package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ASUS on 16.03.2017.
 */
public class Reader {

    private String name;
    private List<Book> books; // or Set()

    public Reader(String name) {

        books = new ArrayList<>();    // or TreeSet()
        this.name = name;
    }

    public Reader(String name, List<Book> books) {

        this.name = name;
        this.books = books;
    }


    public void addBook(Book book) {

        books.add(book);
    }


}
