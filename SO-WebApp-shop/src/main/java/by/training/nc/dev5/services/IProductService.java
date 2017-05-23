package by.training.nc.dev5.services;

import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts() throws DaoException;

    void addProduct(String title, int price) throws DaoException;

    void removeProduct(int idProduct) throws NotFoundException, DaoException;

    void updateProduct(int idProduct, String title, int price) throws NotFoundException, DaoException;

    Product getProductByID(int idProduct) throws NotFoundException, DaoException;

}
