package by.training.nc.dev5.services.impl;

import by.training.nc.dev5.dao.IClientDao;
import by.training.nc.dev5.dao.IOrderingDao;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderingService")
public class OrderingService implements IOrderingService{

    @Autowired
    @Qualifier("OrderingDao")
    IOrderingDao orderingDao;

    @Autowired
    @Qualifier("ClientDao")
    IClientDao clientDao;

    public void addOrdering(int clientId, List<Product> products) throws DaoException, NotFoundException{
        Ordering ordering = new Ordering();
        Client client = clientDao.getById(clientId);
        ordering.setClient(client);
        ordering.setProducts(products);
        orderingDao.add(ordering);
    }

    public void updateOrderingPayment(int orderingId) throws NotFoundException, DaoException {
        Ordering ordering = orderingDao.getById(orderingId);
        ordering.setPaid((byte)1);
        orderingDao.update(ordering);
    }

    public List<Ordering> getAllOrderings() throws DaoException {
        return orderingDao.getAll();
    }

    public List<Ordering> getByClient(int clientId) throws DaoException {
        return orderingDao.getByClient(clientId);
    }

    public Ordering findOrderingById(int orderingId) throws NotFoundException, DaoException {
        return orderingDao.getById(orderingId);
    }
}
