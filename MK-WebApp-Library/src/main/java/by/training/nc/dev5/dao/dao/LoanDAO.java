package by.training.nc.dev5.dao.dao;

import by.training.nc.dev5.model.Loan;

import java.util.Collection;


public interface LoanDAO {
    int insertLoan(Loan pLoan);
    boolean deleteLoan(int id);
    Loan findLoan(int id);
    boolean updateLoan(String pLoanId);
    Collection<Loan> selectLoans();
}
