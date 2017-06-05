package by.training.nc.dev5.services;

import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public interface IOrderingService {

    void addOrdering(int clientId, List<Product> products) throws DaoException, NotFoundException;

    void updateOrderingPayment(int orderingId) throws NotFoundException, DaoException;

    List<Ordering> getAllOrderings() throws DaoException;

    Ordering findOrderingById(int orderingId) throws NotFoundException, DaoException;

    List<Ordering> getByClient(int clientId) throws DaoException;
}
