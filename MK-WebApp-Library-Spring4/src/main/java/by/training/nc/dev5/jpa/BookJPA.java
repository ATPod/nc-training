package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.Book;
import by.training.nc.dev5.entity.Loan;
import by.training.nc.dev5.util.JPAUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("Duplicates")
@Repository
public class BookJPA {


    public Book insertBook(Book book){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        return book;
    }

    public void deleteBook(int id){
        Session session = JPAUtil.getSession();
        EntityTransaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(session.find(Book.class,id));
        session.flush();
        transaction.commit();

    }

    public Book findBookById(int id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Book b = em.find(Book.class,id);
        transaction.commit();
        return b;
    }


    public void updateBook(Book book){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(book);
        transaction.commit();
    }


    public List<Book> selectBooks(){
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Book.selectAll");
        List<Book> books = query.getResultList();
        return books;
    }



}
