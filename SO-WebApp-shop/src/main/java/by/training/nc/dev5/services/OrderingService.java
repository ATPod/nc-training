package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.ClientDao;
import by.training.nc.dev5.dao.OrderingDao;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class OrderingService {

    private static OrderingDao orderingDao = new OrderingDao();

    public static void addOrdering(int idClient, List<Product> products) throws DAOException{
        int [] idProducts = new int[products.size()];
        for (int i = 0; i < products.size(); i++){
            idProducts[i] = products.get(i).getId();
        }
        orderingDao.add(idClient, idProducts);
    }

    public static void updateOrderingPayment(int idOrdering) throws NotFoundException, DAOException{
        orderingDao.findById(idOrdering);
        orderingDao.updatePayment(idOrdering);
    }

    public static List<Ordering> getAllOrderings() throws DAOException{
        return orderingDao.getAll();
    }

    public static List<Ordering> getOrderingsByClientId(int idClient) throws NotFoundException, DAOException{
        new ClientDao().findById(idClient);
        return orderingDao.getByClientId(idClient);
    }
}
