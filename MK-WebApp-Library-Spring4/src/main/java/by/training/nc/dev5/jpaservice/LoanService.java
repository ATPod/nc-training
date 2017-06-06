package by.training.nc.dev5.jpaservice;

import by.training.nc.dev5.entity.Loan;
import by.training.nc.dev5.exception.DbException;
import by.training.nc.dev5.jpa.LoanJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LoanService")
public class LoanService {

    @Autowired
    LoanJPA loanJPA;

    public void insertLoan(Loan loan) throws DbException {

        loanJPA.insertLoan(loan);
    }

    public void updateLoan(Loan loan) throws DbException {

        loanJPA.updateLoan(loan);
    }

    public void deleteLoan(int id) throws DbException {

        loanJPA.deleteLoan(id);
    }

    public void deleteByBook(int book_id){

        loanJPA.deleteByBook(book_id);

    }

    public void deleteByUser(int book_id){

        loanJPA.deleteByBook(book_id);

    }

    public List<Loan> selectLoans() throws DbException {

        return loanJPA.selectLoans();
    }

    /*public static void main(String[] args) {

        LoanService ls = new LoanService();

        try {
            ls.selectLoans().forEach(System.out::println);
        } catch (DbException e) {
            e.printStackTrace();
        }


    }*/

}
