package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.Book;
import by.training.nc.dev5.entity.Loan;
import by.training.nc.dev5.entity.User;
import by.training.nc.dev5.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("Duplicates")
@Repository
public class LoanJPA {

    public void insertLoan (Loan loan){
        //EntityManager em = JPAUtil.getEntityManager();
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.saveOrUpdate(loan);
        transaction.commit();

    }

    public void deleteLoan(int id){
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.delete(s.find(Loan.class,id));
        s.flush();
        transaction.commit();
    }
    public void deleteByBook(int id){
        //EntityManager em = JPAUtil.getEntityManager();
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        Query query = s.createNamedQuery("Loan.deleteByBook");
        query.setParameter("b_id",id);
        query.executeUpdate();
        s.flush();
        //em.getEntityManagerFactory().close(); ??? когда закрывать
        transaction.commit();


    }



    public void updateLoan(Loan loan){
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        EntityManager em = JPAUtil.getEntityManager();
        em.merge(loan);
        transaction.commit();
    }


    public List<Loan> selectLoans(){
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Loan.selectAll");
        List<Loan> loans = query.getResultList();

        //em.getEntityManagerFactory().close(); ??? когда закрывать
        return loans;
    }

/*    public static void main(String[] args) {
         LoanJPA lj = new LoanJPA();
         BookJPA bj = new BookJPA();
         UserJPA uj = new UserJPA();
         User user = uj.findById(111);
         Book book = bj.findBookById(2);

         Loan l = new Loan();

         l.setBook(book);
         l.setUser(user);
         l.setLoanType("wall");
         lj.insertLoan(l);
    }*/
}
