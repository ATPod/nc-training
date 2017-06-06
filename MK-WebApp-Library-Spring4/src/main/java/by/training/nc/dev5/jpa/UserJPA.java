package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.User;
import by.training.nc.dev5.util.JPAUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@SuppressWarnings("Duplicates")
@Repository
public class UserJPA {

    public void insertUser(User user){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();

    }

    public void updateUser(User user){
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.merge(user);
        transaction.commit();

    }

    public void deleteUser(int id){
        Session s = JPAUtil.getSession();
        EntityTransaction transaction = s.getTransaction();
        transaction.begin();
        s.remove(s.find(User.class,id));
        transaction.commit();
    }

    public User findById(int id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User user = em.find(User.class,id);
        transaction.commit();
        return user;
    }

    public User findByNameAndPassword(String name , String password){
        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createNamedQuery("User.findByNameAndPassword");
        query.setParameter(1, name);
        query.setParameter(2, password);

        List<User> users = query.getResultList();
        if(!users.isEmpty()) {
            return  (User) query.getResultList().get(0);
        }else {
            return null ;
        }
    }


    public User findByName(String name ){
        EntityManager em = JPAUtil.getEntityManager();

        Query query = em.createNamedQuery("User.findByName");
        query.setParameter(1, name);
        List<User> users = query.getResultList();
        if(!users.isEmpty()) {
            return  (User) query.getResultList().get(0);
        }else {
            return null ;
        }
    }

    public List<User> selectUsers(){

        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("User.selectAll");
        List<User> users = query.getResultList();

        return users;
    }
/*
    public static void main(String[] args) {
        UserJPA ujpa = new UserJPA();
        User u = ujpa.findByNameAndPassword("qwe","qwe");
        System.out.println(u+ "------------------");

        ujpa.selectUsers().forEach(System.out::println);

    }*/

}
