package by.training.nc.dev5.dao;

import by.training.nc.dev5.model.Loan;
import by.training.nc.dev5.model.LoanView;

import java.util.Collection;


public interface LoanDAO {
    int insertLoan(Loan pLoan);
    boolean deleteLoan(String pLoan);
    Loan findLoan(int pLoanId);
    boolean updateLoan(String pLoanId);
    Collection<LoanView> selectLoans();
}
