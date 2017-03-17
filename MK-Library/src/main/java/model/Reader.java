package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Reader implements Serializable,Comparable<Reader> {

    private String name;
    private List<Book> books; // or Set()

    public Reader(String name) {

        books = new ArrayList<>(); // or TreeSet()
        this.name = name;
    }

    public Reader(String name, List<Book> books) {

        this.name = name;
        this.books = books;
    }


    public void addBook(Book book) {

        books.add(book);
    }


    @Override
    public int compareTo(Reader o) {

        int result = this.name.compareTo(o.name);
        if(result!=0)
            return result;

        return result;
    }
}
