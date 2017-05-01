package by.training.nc.dev5.jpaservice;

import by.training.nc.dev5.entity.jpa.Loan;
import by.training.nc.dev5.jpa.LoanJPA;

import java.util.List;


public class LoanServiceJPA {

    LoanJPA ljpa = new LoanJPA();

    public List<Loan> selectLoans(){
        return ljpa.selectLoans();
    }

    public void deleteLoan(int id){
        ljpa.deleteLoan(id);
    }

}
