package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.jpa.Loan;
import by.training.nc.dev5.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@SuppressWarnings("Duplicates")
public class LoanJPA {

    public void insertLoan (Loan loan){

        Session session = JPAUtil.getSession().getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.persist(loan);

        transaction.commit();


    }

    public List<Loan> selectLoans(){
        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createNamedQuery("Loan.selectAll");
        List<Loan> loans = query.getResultList();

        //em.getEntityManagerFactory().close(); ??? когда закрывать
        return loans;

    }

    public void deleteLoan(int id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(em.find(Loan.class,id));

        transaction.commit();



    }
/*
    public static void main(String[] args) {

        LoanJPA l= new LoanJPA();
        List<Loan> list = l.selectLoans();
        list.forEach(System.out::println);

        List<Loan> list2 = l.selectLoans();
        list2.forEach(System.out::println);


    }
*/
}
