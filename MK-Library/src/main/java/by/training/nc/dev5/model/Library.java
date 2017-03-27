package by.training.nc.dev5.model;

import java.io.*;
import java.util.*;


public class Library implements Serializable {

    private List<Book> books;
    private List<Reader> readers;
    private List<Loan> loans;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }


    public Library() {
        this.books = new ArrayList();       // or TreeSet()
        this.readers = new ArrayList<>();
        this.loans = new ArrayList<>();

    }

}
