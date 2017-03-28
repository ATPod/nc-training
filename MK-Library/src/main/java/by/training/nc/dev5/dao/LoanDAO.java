package by.training.nc.dev5.dao;

import by.training.nc.dev5.model.Loan;

import java.util.Collection;

/**
 * Created by ASUS on 28.03.2017.
 */
public interface LoanDAO {
    int insertLoan(Loan pLoan);
    boolean deleteLoan(String pLoan);
    Loan findLoan(int pLoanId);
    boolean updateLoan(String pLoanId);
    Collection<Loan> selectLoans();
}
