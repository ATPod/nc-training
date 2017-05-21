package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.jpa.Book;
import by.training.nc.dev5.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("Duplicates")
public class BookJPA {


    public Book insertBook(Book book){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(book);

        transaction.commit();
        return book;
    }


    public List<Book> selectBooks(){

        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createNamedQuery("Book.selectAll");
        List<Book> books = query.getResultList();

        return books;
    }


}
