package by.training.nc.dev5.services.impl;

import by.training.nc.dev5.dao.IProductDao;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductService implements IProductService{

    @Autowired
    @Qualifier("ProductDao")
    IProductDao productDao;

    public List <Product> getAllProducts() throws DaoException {
        return productDao.getAll();
    }

    public void addProduct(String title, int price) throws DaoException {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        productDao.add(product);
    }

    public void removeProduct(int idProduct) throws NotFoundException, DaoException {
        Product product = productDao.getById(idProduct);
        productDao.remove(product);
    }

    public void updateProduct(int idProduct, String title, int price) throws NotFoundException, DaoException {
        Product product = productDao.getById(idProduct);
        if (!title.equals("")) {
            product.setTitle(title);
        }
        if (price >= 0){
            product.setPrice(price);
        }
        productDao.update(product);
    }

    public Product getProductByID(int idProduct) throws NotFoundException, DaoException {
        return productDao.getById(idProduct);
    }
}