package by.training.nc.dev5.model;

import java.io.Serializable;


public class Loan implements Serializable {

    private int id;
    private int readerID; //книги / читатели
    private int bookID;

    private Reader reader;
    private Book book;

    private String loanType;
    private String readerName;
    private String bookTitle;

    public Loan(int id, String readerName, String bookTitle, String loanType) {
        this.id = id;
        this.readerName = readerName;
        this.bookTitle = bookTitle;
        this.loanType = loanType;
    }


    public Loan(int id, Reader reader, Book book, String loanType) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.loanType = loanType;
    }






    public int getId() {
        return id;
    }

    public int getReaderID() {
        return readerID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getLoanType() {
        return loanType;
    }
}
