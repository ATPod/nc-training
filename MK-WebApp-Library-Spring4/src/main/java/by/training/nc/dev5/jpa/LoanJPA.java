package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.Loan;
import by.training.nc.dev5.exception.DbException;
import by.training.nc.dev5.util.JPAUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@SuppressWarnings("Duplicates")
@Repository
public class LoanJPA {

    public void insertLoan(Loan loan) throws DbException {
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.saveOrUpdate(loan);
        s.flush();
        transaction.commit();

    }

    public void deleteLoan(int id) throws DbException {
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.delete(s.find(Loan.class, id));
        s.flush();
        transaction.commit();
    }

    public void deleteByBook(int id) throws DbException {
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        Query query = s.createNamedQuery("Loan.deleteByBook");
        query.setParameter("b_id", id);
        query.executeUpdate();
        s.flush();
        transaction.commit();
    }

    public void deleteByUser(int id) throws DbException {
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        Query query = s.createNamedQuery("Loan.deleteByUser");
        query.setParameter("u_id", id);
        query.executeUpdate();
        s.flush();
        transaction.commit();
    }

    public void updateLoan(Loan loan) throws DbException {
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.merge(loan);
        transaction.commit();
    }

    public List<Loan> selectLoansById(int u_id) throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Loan.selectByUser");
        List<Loan> loans = query.getResultList();
        return loans;
    }

    public List<Loan> selectLoans() throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Loan.selectAll");
        List<Loan> loans = query.getResultList();
        return loans;
    }

}
