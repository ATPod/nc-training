package by.training.nc.dev5.daoService;

import by.training.nc.dev5.dao.LoanMySQLDAO;
import by.training.nc.dev5.dao.dao.LoanDAO;
import by.training.nc.dev5.model.Loan;

import java.util.Collection;

/**
 * Created by ASUS on 19.04.2017.
 */
public class LoanService  {

    LoanDAO ldb = new LoanMySQLDAO();

    public int insertLoan(Loan pLoan) {
        return 0;
    }


    public boolean deleteLoan(int id) {
        return false;
    }


    public Loan findLoan(int id) {
        return null;
    }


    public boolean updateLoan(String pLoanId) {
        return false;
    }


    public Collection<Loan> selectLoans() {
        return ldb.selectLoans();
    }
}
