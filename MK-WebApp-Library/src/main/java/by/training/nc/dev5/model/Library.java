package by.training.nc.dev5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Library implements Serializable {

    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }


    public Library() {
        this.books = new ArrayList();       // or TreeSet()
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();

    }

}
