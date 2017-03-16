package model;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ASUS on 16.03.2017.
 */
public class Reader {

    private String name;
    private Set<Book> books ;

    public Reader(String name) {
        books = new TreeSet<>();
        this.name = name;
    }



    public void addBook (Book book){

        books.add(book);
    }




}
