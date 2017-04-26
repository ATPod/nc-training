package by.training.nc.dev5.model;

import java.io.Serializable;


public class Loan implements Serializable {

    private int id;
    private User user;
    private Book book;

    private String loanType;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", book=" + book.getTitle() +
                ", loanType='" + loanType + '\'' +
                '}';
    }

    public Loan(int id, User user, Book book, String loanType) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanType = loanType;
    }


    public int getId() {
        return id;
    }
    public String getLoanType() {
        return loanType;
    }
    public User getUser() {
        return user;
    }
    public Book getBook() {
        return book;
    }
    public int getReaderId() {
        return user.getId();
    }
    public int getBookId() {
        return book.getId();
    }
}
