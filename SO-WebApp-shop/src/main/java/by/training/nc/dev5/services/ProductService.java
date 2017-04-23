package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.ProductDao;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public class ProductService {

    public static ProductDao productDao = new ProductDao();

    public static List <Product> getAllProducts() throws DAOException{
        return productDao.getAll();
    }

    public static void addProduct(String title, int price) throws DAOException{
        productDao.add(title, price);
    }

    public static void removeProduct(int idProduct) throws NotFoundException, DAOException{
        productDao.findById(idProduct);
        productDao.delete(idProduct);
    }

    public static void updateProductTitle(int idProduct, String title) throws NotFoundException, DAOException{
        productDao.findById(idProduct);
        productDao.updateTitle(idProduct, title);
    }

    public static void updateProductPrice(int idProduct, int price) throws NotFoundException, DAOException{
        productDao.findById(idProduct);
        productDao.updatePrice(idProduct, price);
    }

    public static Product getProductByID(int idProduct) throws NotFoundException, DAOException{
        return productDao.findById(idProduct);
    }
}
