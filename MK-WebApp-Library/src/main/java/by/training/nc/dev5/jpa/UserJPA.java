package by.training.nc.dev5.jpa;

import by.training.nc.dev5.entity.jpa.User;
import by.training.nc.dev5.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@SuppressWarnings("Duplicates")
public class UserJPA {

    public User insertUser(User user){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(user);

        transaction.commit();
        return user;
    }

    public void updateUser(User user){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(user);

        transaction.commit();
    }

    public User findById(int id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User user = em.find(User.class,id);

        //em.flush(); пропихнуть данные в бд иначе произойдет после коммита транзакции
        transaction.commit();
        return user;
    }


    public User findByNameAndPassword(String name , String password){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Query query = em.createNamedQuery("User.findByNameAndPassword");
        query.setParameter(1, name);
        query.setParameter(2, password);

        List<User> users = query.getResultList();
        if(users.isEmpty()==false) {
            return  (User) query.getResultList().get(0);
        }else {
            return null ;
        }
    }

/*
    public static void main(String[] args) {
        UserJPA ujpa = new UserJPA();
        User u = ujpa.findByNameAndPassword("qwerty","12345");
        System.out.println(u);
    }
*/
}
