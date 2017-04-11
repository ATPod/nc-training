package by.training.nc.dev5.model;

import java.io.Serializable;


public class Loan implements Serializable {

    private int id;
    private Reader reader;
    private Book book;



    private String loanType;


    public Loan(int id, Reader reader, Book book, String loanType) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.loanType = loanType;
    }


    public int getId() {
        return id;
    }
    public String getLoanType() {
        return loanType;
    }
    public Reader getReader() {
        return reader;
    }
    public Book getBook() {
        return book;
    }
    public int getReaderId() {
        return reader.getId();
    }
    public int getBookId() {
        return book.getId();
    }
}
