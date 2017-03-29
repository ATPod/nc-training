package by.training.nc.dev5.model;

import java.io.Serializable;


public class Loan implements Serializable {

    private int id;
    private int readerID;
    private int bookID;
    private String loanType;
    private String readerName;
    private String bookTitle;

    public Loan(int id, String readerName, String bookTitle, String loanType) {
        this.id = id;
        this.readerName = readerName;
        this.bookTitle = bookTitle;
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
