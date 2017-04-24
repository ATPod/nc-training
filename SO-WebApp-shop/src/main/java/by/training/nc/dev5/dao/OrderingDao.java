package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class OrderingDao {

    public void add(Client client, List <Product> productList) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Ordering ordering = new Ordering();
            ordering.setClient(entityManager.find(Client.class, client.getId()));
            ordering.setPaid((byte) 0);

            List<Product> products = new ArrayList<>();
            for (int i = 0; i < productList.size(); i++) {
                products.add(entityManager.find(Product.class, Integer.valueOf(productList.get(i).getId())));
            }

            ordering.setProducts(products);

            entityManager.getTransaction().begin();
            entityManager.persist(ordering);
            entityManager.flush();
            entityManager.getTransaction().commit();
            /*
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Ordering ordering = new Ordering();
            ordering.setClient(client);
            ordering.setPaid((byte) 0);
            ordering.setProducts(productList);

            entityManager.getTransaction().begin();
            entityManager.persist(ordering);
            entityManager.flush();
            entityManager.getTransaction().commit();*/
        }
        catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public static Ordering findById(int id) throws NotFoundException, DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Ordering ordering = entityManager.find(Ordering.class, id);
            if (ordering != null){
                return ordering;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public static List<Ordering> getAll() throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Ordering.findAll");
            List<Ordering> orderingList = (List<Ordering>) query.getResultList();
            return orderingList;
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public static void updatePayment(int id) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Ordering ordering = entityManager.find(Ordering.class, id);
            ordering.setPaid((byte)1);
            entityManager.getTransaction().begin();
            entityManager.merge(ordering);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }
}
