package by.training.nc.dev5.dao.impl;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.dao.IProductDao;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("ProductDao")
@Transactional
public class ProductDao extends AbstractDao<Product> implements IProductDao {

    @Transactional(readOnly = true)
    public Product getById(int id) throws DaoException, NotFoundException {
        try {
            Product product = getSession().find(Product.class, id);
            if (product != null){
                return product;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() throws DaoException {
        try {
            Query query = getSession().createNamedQuery("Product.findAll");
            List<Product> productList = (List<Product>) query.getResultList();
            return productList;
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
}
