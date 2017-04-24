package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductDao {

    public void add(String title, int price) throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Product product = new Product();
            product.setTitle(title);
            product.setPrice(price);
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void remove(int id) throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Product product = entityManager.find(Product.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Product findById(int id) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Product product = entityManager.find(Product.class, id);
            if (product != null){
                return product;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public List<Product> getAll() throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Product.findAll");
            List<Product> productList = (List<Product>) query.getResultList();
            return productList;
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updateTitle(int id, String newTitle) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Product product = entityManager.find(Product.class, id);
            product.setTitle(newTitle);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updatePrice(int id, int newPrice) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Product product = entityManager.find(Product.class, id);
            product.setPrice(newPrice);
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }
}
