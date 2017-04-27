package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.ClientDao;
import by.training.nc.dev5.dao.OrderingDao;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public class OrderingService {

    private static OrderingDao orderingDao = new OrderingDao();

    public static void addOrdering(int clientId, List<Product> products) throws DAOException, NotFoundException{
        Client client = new ClientDao().findById(clientId);
        int [] idProducts = new int[products.size()];
        for (int i = 0; i < products.size(); i++){
            idProducts[i] = products.get(i).getId();
        }
        orderingDao.add(client, products);
    }

    public static void updateOrderingPayment(int orderingId) throws NotFoundException, DAOException{
        orderingDao.findById(orderingId);
        orderingDao.updatePayment(orderingId);
    }

    public static List<Ordering> getAllOrderings() throws DAOException{
        return orderingDao.getAll();
    }

    public static Ordering findOrderingById(int orderingId) throws NotFoundException, DAOException{
        return orderingDao.findById(orderingId);
    }
}
