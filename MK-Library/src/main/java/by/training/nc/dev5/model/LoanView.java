package by.training.nc.dev5.model;

/**
 * Created by ASUS on 29.03.2017.
 */
public class LoanView {

    private String userName;
    private String bookTitle;
    private String loanType;

    public LoanView(String userName, String bookTitle, String loanType) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.loanType = loanType;
    }

    @Override
    public String toString(){
        return userName+" "+bookTitle+" "+loanType;
    }

}
